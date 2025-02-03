package api.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamEx {

	public static void main(String[] args) {
		/*
		 * 파일을 읽어들이는 클래스 FileInputStream
		 * 
		 * 1바이트 단위로 읽어 들이기 때문에, 한글을 사용하는데는 문제가 있음.
		 */
		
		String path = "C:\\Users\\user\\Desktop\\course\\java\\file\\hello.txt";
		
		InputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
			
			//한글자씩 읽기
			while(true) {
				int data = fis.read(); //읽은 데이터 한글자 반환
				if(data == -1) break;
				System.out.print( (char)data  );
			}
			
			
			//바이트 배열로 읽기
//			byte[] arr = new byte[100];
//			int result = fis.read(arr); //읽은 데이터의 길이를 반환
//			System.out.println("읽어들인 데이터길이:" + result );
//			System.out.println(Arrays.toString(arr));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e2) {
			}
		}
		
		
		
		
		
	}
}
