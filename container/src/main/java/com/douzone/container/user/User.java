package com.douzone.container.user;

public class User {
	private Long no = 0L;
	private String name = "루피";
	
	public void setNo(Long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(Long no,String name) {
		this.name = name;
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + "]";
	}
	
	
}
