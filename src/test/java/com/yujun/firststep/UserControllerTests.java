package com.yujun.firststep;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yujun.firststep.web.UserInfoController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {
	private MockMvc mvc;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserInfoController()).build();
	}
	
	@Test
	public void getEmptyUsers() throws Exception{
		mvc.perform(get("/users/")).andExpect(status().isOk())
			.andExpect(content().string(equalTo("[]")));
	}
	
	@Test
	public void addUser() throws Exception{
		mvc.perform(post("/users/add").param("id", "001").param("name", "YJ").param("age", "29"))
				.andExpect(status().isOk())
				.andExpect(content().string("true"));
	}
	
	@Test
	public void getAllUsers() throws Exception{
		mvc.perform(get("/users/")).andExpect(status().isOk())
			.andExpect(content().string(equalTo("[{\"id\":\"001\",\"name\":\"YJ\",\"age\":29}]")));
	}
	
	@Test
	public void updateUser() throws Exception{
		mvc.perform(put("/users/001").param("id", "002").param("name", "yujun").param("age", "18"))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("true")));
	}
	
	@Test
	public void getUpdatedUsers() throws Exception{
		mvc.perform(get("/users/")).andExpect(status().isOk())
			.andExpect(content().string(equalTo("[{\"id\":\"002\",\"name\":\"yujun\",\"age\":18}]")));
	}
}
