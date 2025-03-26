package pieum.capsule.model;

import java.sql.Timestamp;

public class InquiryDTO {

	
	// 1:1문의/공지
	private String nno;
	private String ntitle;
	private String nncontent;
	private Timestamp nregdate;
	private String acontent;
	
	public InquiryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public InquiryDTO(String nno, String ntitle, String nncontent, Timestamp nregdate, String acontent) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.nncontent = nncontent;
		this.nregdate = nregdate;
		this.acontent = acontent;
	}




	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNncontent() {
		return nncontent;
	}
	public void setNncontent(String nncontent) {
		this.nncontent = nncontent;
	}
	public Timestamp getNregdate() {
		return nregdate;
	}
	public void setNregdate(Timestamp nregdate) {
		this.nregdate = nregdate;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	
	
}
