package pieum.user.model;

public class UserMapingTableDTO {

	// 그룹 맵핑테이블
	private String mno;
	private String gno;
	private char gAccept;
	private char gOut;
	
	public UserMapingTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserMapingTableDTO(String mno, String gno, char gAccept, char gOut) {
		super();
		this.mno = mno;
		this.gno = gno;
		this.gAccept = gAccept;
		this.gOut = gOut;
	}
	
	
}
