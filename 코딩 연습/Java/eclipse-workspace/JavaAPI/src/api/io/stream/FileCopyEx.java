package api.io.stream;
import java.io.*;
import java.util.Arrays;
public class FileCopyEx {
	public static void main(String args[]) {
		
		InputStream fis = null;
		OutputStream fos = null;
		
		String inputPath="C:\\Users\\Windows\\Desktop\\file\\copy.png"; // 읽어들일 파일명
		String outputPath="C:\\Users\\Windows\\Desktop\\file\\filecopy\\hello.png"; // 저장할 파일명
		
		try {
			fis = new FileInputStream(inputPath);
			fos = new FileOutputStream(outputPath);
			
			//100바이트 단위로 읽은
			byte[] arr = new byte[100];
			
			int result;
			// 읽은 길이 반환, 더이상 읽을 데이터가 없으면 -1 반환
			while((result=fis.read(arr))!=-1) {
				System.out.println(Arrays.toString(arr));
				fos.write(arr, 0, result); // 데이터, 시작위치, 쓸위치
			}
			
			System.out.println("파일 복사 성공");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			fis.close();
			fos.close();
			}catch(IOException e2){
				
			}
		}
	}
}
