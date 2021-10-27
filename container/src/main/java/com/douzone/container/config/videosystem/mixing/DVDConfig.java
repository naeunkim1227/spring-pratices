package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.BlankDisc;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
		//클래스 가져와서 정보 주는것
	}
	
	@Bean(name = "blackWidow")
	public DigitalVideoDisc blankDisc() {
		BlankDisc dvd = new BlankDisc();
		dvd.setTitle("Black Widow");
		dvd.setStudio("MARVEL2");
		//직접 내가 지정한것
		return dvd;
	}
	
	
	
	
}
