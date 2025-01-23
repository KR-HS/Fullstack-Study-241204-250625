package api.io.stream;
import java.io.*;
public class FileReaderEx {
	public static void main(String[] args) {
		/*
		 * 2바이트 기반으로 문자를 읽어들일 떄 사용하는 클래스 FileReader
		 */
		String path="C:\\Users\\Windows\\Desktop\\file\\bye.txt";
		Reader rd = null;
		try {
			rd = new FileReader(path);
			int result;
			while((result=rd.read())!=-1) { // 한글자를 읽어들임, 더이상 읽을 값이 없으면 -1
				System.out.print((char)result);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				rd.close();
			}catch(IOException e2) {
				
			}
		}
	}
}
