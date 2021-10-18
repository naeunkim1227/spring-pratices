package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



//@RequestMapping 메소드 단독 매핑 > 메소드마다 매핑 하기

@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
		
	}

	@ResponseBody
	@RequestMapping("/board/view")
	public String view() {
		return "BoardController.write()";
		
	}
	
}
