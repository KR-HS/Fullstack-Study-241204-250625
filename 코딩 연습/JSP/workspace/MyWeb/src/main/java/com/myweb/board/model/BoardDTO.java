package com.myweb.board.model;

import java.sql.Timestamp;

public class BoardDTO {
	private int bno;
	private String email;
	private String title;
	private String content;
	private String regdate;
	
	public BoardDTO() {
	}

	public BoardDTO(int bno, String email, String title, String content, String regdate) {
		this.bno = bno;
		this.email = email;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
