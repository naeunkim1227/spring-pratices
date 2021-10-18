package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainConroller {
	
	//복수매핑
	@ResponseBody
	@RequestMapping({"","/main", "/main/a"})
	public String main() {
		
		
		return "<h1>heeeeeyyy~~~~</h1>";
	}
}
