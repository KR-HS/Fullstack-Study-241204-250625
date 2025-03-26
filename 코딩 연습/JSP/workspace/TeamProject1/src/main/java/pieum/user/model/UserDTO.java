package pieum.user.model;

import java.sql.Timestamp;

public class UserDTO {

	//사용자
	private String mno;
	private String mid;
	private String mpw;
	private String mname;
	private String gender;
	private String birth;
	private String phone;
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String mno, String mid, String mpw, String mname, String gender, String birth, String phone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
