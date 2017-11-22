package com.yujun.firststep.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	@RequestMapping("/")
	public String index(ModelMap map){
		map.addAttribute("host", "testhostyujun");
		return "index";
	}
}
