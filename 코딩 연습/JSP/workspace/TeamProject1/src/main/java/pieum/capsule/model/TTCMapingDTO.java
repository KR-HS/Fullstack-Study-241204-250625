package pieum.capsule.model;

public class TTCMapingDTO {

	
	// 태그 x 타임캡슐맵핑
	private String tno;
	private String tcno;
	
	public TTCMapingDTO() {
		// TODO Auto-generated constructor stub
	}

	public TTCMapingDTO(String tno, String tcno) {
		super();
		this.tno = tno;
		this.tcno = tcno;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	
	
}
