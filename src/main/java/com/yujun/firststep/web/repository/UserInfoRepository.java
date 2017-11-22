package com.yujun.firststep.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.yujun.firststep.web.model.UserInfo;

@Component(value="userInfoRepository")
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
	UserInfo findByName(String name);
	
	UserInfo findByUserId(String userId);
	
    @Query("from UserInfo u where u.name=:name")
    UserInfo findUser(@Param("name") String name);

}
