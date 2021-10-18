package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author user
 *@RequsetMapping 클래스(타입) + 핸들러(메소드)
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value ="/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	
	@RequestMapping(value ="/join", method = RequestMethod.POST)
	public String join(UserVO vo) {
		System.out.println(vo);
		//userDao.insert(vo)
		return "redirect:/";
	}
	
	//@RequestParam("n") String name n을 받아서 String 타입 name변수에 저장한다.
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		
		/*만일 n이라는 이름의 파라미터가 없는 경우, 400 bad request 에러가 발생한다*/
		//required = true,false를 작성하여 오류를 방지하자.
		//@RequestParam(value="n",required=true, defaultValue = "")
		System.out.println(name);
		return "UserController.join()";
	}
	
	//@RequestParam("n") String name n을 받아서 String 타입 name변수에 저장한다.
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n",required=true, defaultValue = "") String name, 
			@RequestParam(value = "a", required = true, defaultValue = "0") int age){
		//디폴트 값을 지정해준다.
	
		/*만일 n이라는 이름의 파라미터가 없는 경우, 400 bad request 에러가 발생한다*/
		System.out.println("---- " + name +" ----" );
		return "UserController.update()";
	}
}
