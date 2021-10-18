package com.douzone.hellospring.controller;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		
		//mav에 데이터와 뷰저장
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		
		return mav; 
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		//모델앤뷰 타입보다, String으로 선언후 변수에 모델 저장하기
		model.addAttribute("name",name);

		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		//ResponseBody : 내가 직접, 바디에 쓰겠다.. 브라우저에 텍스트가 그대로 나타남
		return "<h1>heeeyyy</h1>";
	}
	
	@RequestMapping("/hello6")
	public String hello6() {

		System.out.println("hello6() called");
		return "redirect:/hello";
	}

	
}
