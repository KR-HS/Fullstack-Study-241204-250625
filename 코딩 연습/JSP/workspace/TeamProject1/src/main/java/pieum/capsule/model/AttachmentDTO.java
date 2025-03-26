package pieum.capsule.model;

public class AttachmentDTO {

	// 첨부파일
	private String fno;
	private String filename;
//	private byte[] fileData;
	
	public AttachmentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AttachmentDTO(String fno, String filename) {
		super();
		this.fno = fno;
		this.filename = filename;
//		this.fileData = fileData;
	}



	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
//	public String getFileData() {
//		return fileData;
//	}
//	
//	public void setFileData(byte[] fileData) {
//		this.fileData = fileData;
//	}
	
}
