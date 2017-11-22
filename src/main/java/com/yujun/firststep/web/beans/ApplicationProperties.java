package com.yujun.firststep.web.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private String age;
	
	@Value("${sentence}")
	private String sentence;

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
	
	public String getSentence() {
		return sentence;
	}
}
