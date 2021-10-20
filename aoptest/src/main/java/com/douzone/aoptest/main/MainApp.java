package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		//컨테이너 생성 > 파일에서 정보 읽어온다.
		ApplicationContext ac 
		= new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		
		//ProductService를 가져오게 된다.
		ProductService ps =  ac.getBean(ProductService.class);
		//ProductService타입의 클래스를 찾아서..
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
		
		((AbstractApplicationContext)ac).close();
		
	}

}
