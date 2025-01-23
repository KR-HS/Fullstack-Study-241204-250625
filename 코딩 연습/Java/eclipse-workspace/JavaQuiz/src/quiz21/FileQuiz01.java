package quiz21;
import java.io.*;
import java.util.*;
public class FileQuiz01 {
	public static void main(String[] args) {
		/*
		 * 1. 스캐너를 이용해 파일명을 입력받음
		 * 2. file폴더 하위에 입력받은 파일명으로 파일을 씀
		 * 3. 파일을 쓸 때, "쓰고 싶은 말"을 사용자에게 입력받음
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력(확장자 포함)>>");
		String fileName = sc.nextLine();
		
		String path = "C:\\Users\\Windows\\Desktop\\file\\"+fileName;
		
		Writer fw = null;
		
		try {
			fw= new FileWriter(path);
			System.out.println("입력할 내용");
			while(true) {
			System.out.print("(종료하려면 0을 입력하시오) >>");
			String input= sc.nextLine();
			if(input.equals("0")) break;
			fw.write(input+"\n");
			}
			System.out.println("입력 완료");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			fw.close();
			}catch(IOException e2) {}
			
		}
	}
}
