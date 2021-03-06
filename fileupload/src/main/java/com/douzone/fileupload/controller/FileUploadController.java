package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileuploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping({"", "/form"})
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "file") MultipartFile multipartFile,
			Model model) {
		
		//받고자 하는 파일이 여러개일경우 파라미터를 다르게 하는 것 보다
		//@RequestParam(value = "file", MultipartFile[] ) 로 배열로 받는게 좋다
		
		System.out.println("email : " + email);
		String url = fileuploadService.restore(multipartFile);
		model.addAttribute("url", url);
		
		return "/WEB-INF/views/result.jsp";
	}
	
}
