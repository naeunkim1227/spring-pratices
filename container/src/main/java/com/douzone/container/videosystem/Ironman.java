package com.douzone.container.videosystem;

public class Ironman implements DigitalVideoDisc{
	private String title = "Ironman";
	private String studio = "MARVEL";
	
	@Override
	public void play() {
		System.out.println("Playing Movie " +  studio + "'s " + title);
	}
	
	
}
