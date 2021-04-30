package com.ssafy.homework.model.dto;

public class User {
	private String id;
	private String pass;
	private String name;
	public User() {}
	public User(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
