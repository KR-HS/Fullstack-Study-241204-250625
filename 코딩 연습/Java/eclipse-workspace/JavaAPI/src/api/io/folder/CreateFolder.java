package api.io.folder;

import java.io.File;

public class CreateFolder {

	public static void main(String[] args) {
		
		/*
		 * 폴더 생성할 때는 File클래스를 사용합니다.
		 * 생성자 매개변수로 폴더를 생성할 경로 + 폴더명 을 지정합니다.
		 */
		String path = "C:\\Users\\user\\Desktop\\file\\myfolder";
		
		try {
			
			File file = new File(path);
			
			if( !file.exists() ) { //파일이 존재하면 true
				file.mkdir(); //폴더 생성
				System.out.println("폴더가 생성 되었습니다");
			} else {
				file.delete(); //폴더 삭제(파일삭제)
				System.out.println("폴더가 이미 있습니다");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
	}
}
