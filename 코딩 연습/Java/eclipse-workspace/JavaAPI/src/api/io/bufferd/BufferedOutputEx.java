package api.io.bufferd;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutputEx {

	public static void main(String[] args) {
		/*
		 * Buffered가 붙은 클래스는 입출력 성능향상을 위한 스트림 클래스입니다.
		 * 
		 * Buffered + 스트림타입 으로, 이름이 결정됩니다.
		 * 
		 * BufferedOutputStream 는 outputstream의 성능향상 스트림입니다. 
		 */
		
		String path = "C:\\Users\\user\\Desktop\\course\\java\\file\\test01.txt";
		
		//OutputStream os = null;
		BufferedOutputStream bos = null;
		
		try {
			//os = new FileOutputStream(path);
			bos = new BufferedOutputStream( new FileOutputStream(path) );
			
			String str = "youjin choi? good morning?";
			
			bos.write( str.getBytes() ); //파일을 씀
			bos.flush(); //버퍼를 밀어냄 (데이터가 전달됨)
			
			//Thread.sleep(20000); //20초 스탑
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (Exception e2) {
			}
		}
		
		System.out.println("프로그램 정상 종료");
		//프로그램이 종료되면 버퍼가 자동으로 비워짐.
		
		
		
		
		
		
		
	}
}
