package api.io.stream;
import java.io.*;
public class FileWriterEx {
	public static void main(String[] args) {
		/*
		 * 문자를 써서 파일을 저장할 때 사용하는 클래스는 FileWriter
		 * 2바이트 기반으로 동작하기 때문에, 한글처리가 가능
		 * 
		 */
		Writer fw = null;
		
		String path="C:\\Users\\Windows\\Desktop\\file\\bye.txt";
		try {
			fw = new FileWriter(path);
			
			String str ="지금은 4시 12분 입니다.\n11";
			fw.write(str);
			System.out.println("파일 출력 완료");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e2) {
			}
		}
	}
}
