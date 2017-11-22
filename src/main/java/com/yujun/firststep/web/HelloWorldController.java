package com.yujun.firststep.web;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujun.firststep.web.beans.ApplicationProperties;
import com.yujun.firststep.web.exceptions.MyException;

@RestController
@RequestMapping("/main")
public class HelloWorldController {
	
	@Autowired 
	private ApplicationProperties aps;
	
	@RequestMapping("/hello")
	public String index(){
		return "Hello World";
	}
	
	@RequestMapping("sentence")
	public String getSentence() {
		return aps.getSentence();
	}
	
	@RequestMapping("error")
	public void error() throws FileNotFoundException{
		throw new FileNotFoundException("file not found error");
	}
	
	@RequestMapping("json")
	public void jsonError() throws MyException{
		throw new MyException("my test exception");
	}
}
