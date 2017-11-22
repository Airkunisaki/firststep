package com.yujun.firststep.web.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yujun.firststep.FirststepApplication;
import com.yujun.firststep.web.model.UserInfo;
import com.yujun.firststep.web.repository.UserInfoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=FirststepApplication.class)
public class UserInfoRepositoryTests {

	@Autowired
	private UserInfoRepository repository;
	
	@Test
	public void getUser() throws Exception {
//		repository.save(new UserInfo("001","李四", new Date(), "male"));
//		repository.save(new UserInfo("002","陈红", new Date(), "female"));
		if (repository.findByUserId("001") == null){
			repository.save(new UserInfo("001","李四", new Date(), "male"));
			repository.save(new UserInfo("002","陈红", new Date(), "female"));
		}
		Assert.assertEquals("male", repository.findByUserId("001").getSex());
	}
}
