package com.yujun.firststep.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo {
	
	public UserInfo(){}
	
	public UserInfo(String userId, String name, Date date , String sex){
		super();
		this.userId = userId;
		this.name = name;
		this.date = date;
		this.sex = sex;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true) 
	private String userId;
	
	@Column
	private String name;
	
	@Column
	private String sex;
	
	@Column(name="signup_date")
	private Date date;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Date getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setDate(Date date) {
		this.date = date;
	}
		
}
