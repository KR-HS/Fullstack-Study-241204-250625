package pieum.capsule.model;

import java.sql.Timestamp;

public class TimeCapsuleDTO {

	// 타임캡슐
	private String tcno;
	private Timestamp tcRegdate;
	private String openDate;
	private String tcTitle;
	private String tcContent;
	private char privates;
	private int viewCt;
	
	public TimeCapsuleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public TimeCapsuleDTO(String tcno, Timestamp tcRegdate, String openDate, String tcTitle, String tcContent,
			char privates, int viewCt) {
		super();
		this.tcno = tcno;
		this.tcRegdate = tcRegdate;
		this.openDate = openDate;
		this.tcTitle = tcTitle;
		this.tcContent = tcContent;
		this.privates = privates;
		this.viewCt = viewCt;
	}




	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public Timestamp getTcRegdate() {
		return tcRegdate;
	}
	public void setTcRegdate(Timestamp tcRegdate) {
		this.tcRegdate = tcRegdate;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getTcTitle() {
		return tcTitle;
	}
	public void setTcTitle(String tcTitle) {
		this.tcTitle = tcTitle;
	}
	public String getTcContent() {
		return tcContent;
	}
	public void setTcContent(String tcContent) {
		this.tcContent = tcContent;
	}
	public char getPrivates() {
		return privates;
	}
	public void setPrivates(char privates) {
		this.privates = privates;
	}
	public int getViewCt() {
		return viewCt;
	}
	public void setViewCt(int viewCt) {
		this.viewCt = viewCt;
	}
	
	
	
}
