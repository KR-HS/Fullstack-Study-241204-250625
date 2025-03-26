package pieum.capsule.model;

public class TagDTO {

	// 태그
	private String tno;
	private String tName;
	
	public TagDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TagDTO(String tno, String tName) {
		super();
		this.tno = tno;
		this.tName = tName;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	
	
	
	
}
