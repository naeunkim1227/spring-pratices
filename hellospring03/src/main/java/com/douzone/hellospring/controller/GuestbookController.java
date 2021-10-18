package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 
//클래스 타입 단독 매핑
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	
	//클래스에 매핑을 해줬고 /* 로 모든 아래의 메소드까지 포함, 아래의 RequestMapping에는 따로 작성하지 않고 
	//메소드 이름으로 주소지가 설정되게 된다.
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GusetbookController.list()";
	}

	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GusetbookController.list()";
	}
	
}
