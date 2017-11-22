package com.yujun.firststep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.yujun.firststep","com.yujun.newweb"})
@SpringBootApplication
public class FirststepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirststepApplication.class, args);
	}
	
}