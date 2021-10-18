package com.douzone.guestbook.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.guestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<guestbookVO> list = guestbookRepository.findall();
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(guestbookVO vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET )
	public String delete() {
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	
	@RequestMapping(value = "/delete")
	public String delete(guestbookVO vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
}