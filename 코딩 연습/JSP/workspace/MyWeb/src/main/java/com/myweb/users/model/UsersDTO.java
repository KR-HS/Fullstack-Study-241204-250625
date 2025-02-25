package com.myweb.users.model;

import java.sql.Timestamp;

public class UsersDTO {
	private String email;
	private String name;
	private String pw;
	private String phone;
	private String gender;
	private String snsYn;
	private Timestamp regdate;
	
	public UsersDTO() {

	}
	
	
	public UsersDTO(String email, String name, String pw, String phone, String gender, String snsYn,
			Timestamp regdate) {
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.gender = gender;
		this.snsYn = snsYn;
		this.regdate = regdate;
	}


	//getter, setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSnsYn() {
		return snsYn;
	}

	public void setSnsYn(String snsYn) {
		this.snsYn = snsYn;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
