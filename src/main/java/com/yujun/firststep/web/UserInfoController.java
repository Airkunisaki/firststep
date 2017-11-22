package com.yujun.firststep.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yujun.firststep.web.request.form.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserInfoController {
	
	private static Map<String, User> userMap = Collections.synchronizedMap(new HashMap<String, User>());
	
	@ApiOperation(value="获取用户列表", notes="")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		return new ArrayList<User>(userMap.values());
	}
	
	@ApiOperation(value="添加用户", notes="根据User对象添加用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public boolean addUsers(@ModelAttribute User user) {
		userMap.put(user.getId(), user);
		return true;
	}
	
	@ApiOperation(value="更新用户", notes="根据url的id来找到用户，并根据User对象更新该用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType="path", dataType = "String"),
        @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public boolean updateUser(@PathVariable String id, @ModelAttribute User user){
		userMap.put(id, user);
		return true;
	}
}
