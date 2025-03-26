package pieum.capsule.model;

import java.sql.Timestamp;

public class CommentDTO {

	
	// 댓글
	private String cno;
	private String cContent;
	private Timestamp cRegdate;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDTO(String cno, String cContent, Timestamp cRegdate) {
		super();
		this.cno = cno;
		this.cContent = cContent;
		this.cRegdate = cRegdate;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Timestamp getcRegdate() {
		return cRegdate;
	}

	public void setcRegdate(Timestamp cRegdate) {
		this.cRegdate = cRegdate;
	}
	
	
	
	
	
}
