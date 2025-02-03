package api.io.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {

	public static void main(String[] args) {
		
		/*
		 * io패키지의 모든 클래스는 생성자가 throws키워드를 던지고 있어서
		 * 모두 try~catch블록과 함께 사용합니다.
		 * 
		 */
		
		String path = "C:\\Users\\user\\Desktop\\course\\java\\file\\hello.txt";
		
		OutputStream fos = null;
		
		try {
			fos = new FileOutputStream(path);
			
			String str = "hey! gildong! wake up!!";
			fos.write( str.getBytes() );
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e2) {

			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
