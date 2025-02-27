package com.myweb.board.model;

import java.sql.Timestamp;

public class BoardDTO {
	private int bno;
	private String email;
	private String title;
	private String content;
	private String regdate;
	
	
	private String prevNo; // 데이터베이스의 스네이크표기법을 카멜로 자동 변경
	private String prevTitle;
	private String nextNo;
	private String nextTitle;
	
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

	public String getPrevNo() {
		return prevNo;
	}

	public void setPrevNo(String prevNo) {
		this.prevNo = prevNo;
	}

	public String getPrevTitle() {
		return prevTitle;
	}

	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}

	public String getNextNo() {
		return nextNo;
	}

	public void setNextNo(String nextNo) {
		this.nextNo = nextNo;
	}

	public String getNextTitle() {
		return nextTitle;
	}

	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}

	
}
