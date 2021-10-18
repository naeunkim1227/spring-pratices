package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable("no") Long boardNo) {
		//파라미터 값으로 ?n=10 다음과 같이 전달하지 않고 /뒤에 바로 변수를 입력해 이동하게 하는 방법으로 
		//PathVariable을 통해 mapping한 {} 의 변수값을 지정해줄 수 있다.
		
		System.out.println("("+ boardNo + ")");
		return "BoardController.write("+ boardNo + ")";
		
	}
	
}
