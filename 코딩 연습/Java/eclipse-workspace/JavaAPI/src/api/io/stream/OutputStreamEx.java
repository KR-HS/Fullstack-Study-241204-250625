package api.io.stream;

import java.io.*;

public class OutputStreamEx {
	public static void main(String[] args) {
		
		/*
		 * 
		 * io패키지의 모든 클래스는 생성자가 throws키워드를 던지고 있어서
		 * 모두 try~catch블록과 함께 사용해야 함
		 * 
		 * 
		 */
		
		String path = "C:\\Users\\Windows\\Desktop\\hello.txt";
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(path);
			String str = "길동이";
			fos.write(str.getBytes());
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
