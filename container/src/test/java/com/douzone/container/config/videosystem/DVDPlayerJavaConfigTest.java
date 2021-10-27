package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.soundsystem.CDPlayer;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd;
	
	
	
	//같은 타입의 빈이 2개이상 존재하는 경우  1
	//설정 클래스의 빈생성 메소드 이름
	//1. xml의 경우 bean id이름을 주면 되지만, java의 경우 메소드 이름으로 준다.
	@Qualifier("dvdPlayer03")
	@Autowired
	private DVDPlayer dvdplayer03;
	
	//설정 클래스의 빈생성 메소드의 @Bean의 어노테이션에 name 속성을 사용한다.
	@Qualifier("dvdPlayer04")
	@Autowired
	private DVDPlayer dvdplayer04;
	
	
	@Test
	public void testDVDNotNull() {
		assertNotNull(dvd);
	}
	
	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdplayer03);
	}
	
	@Test
	public void testDVDPlayer04NotNull() {
		assertNotNull(dvdplayer04);
	}
	
	@Test
	public void testDVDPlayer04() {
		dvdplayer03.play();
		System.out.println("----------------------------");
		dvdplayer04.play();
		assertEquals("Playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
	
}