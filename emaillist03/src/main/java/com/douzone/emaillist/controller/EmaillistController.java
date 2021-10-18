package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVO;

@Controller
public class EmaillistController {
	//의존성 주입
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVO> list= emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
		
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVO vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
	
	
}
