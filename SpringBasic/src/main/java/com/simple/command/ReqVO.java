package com.simple.command;

import java.util.List;

public class ReqVO {
	//폼값의 name과 일치하는 변수를 멤버변수로 선언
	private String id;
	private String pw;
	private String name;
	private int age;
	private List<String> inter;
	
	
	public ReqVO() {}
	
	
	
	public ReqVO(String id, String pw, String name, int age, List<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.inter = inter;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getInter() {
		return inter;
	}

	public void setInter(List<String> inter) {
		this.inter = inter;
	}
	
	 
}
