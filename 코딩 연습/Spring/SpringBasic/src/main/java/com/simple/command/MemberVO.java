package com.simple.command;

import java.util.*;

public class MemberVO { // DTO와 동일

	private String id;
	private String pw;
	private String name;
	private List<String> inter;
	
	
	public MemberVO() {
	}


	public MemberVO(String id, String pw, String name, List<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
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


	public String getname() {
		return name;
	}


	public void setname(String name) {
		this.name = name;
	}


	public List<String> getInter() {
		return inter;
	}


	public void setInter(List<String> inter) {
		this.inter = inter;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", inter=" + inter + "]";
	}
}
