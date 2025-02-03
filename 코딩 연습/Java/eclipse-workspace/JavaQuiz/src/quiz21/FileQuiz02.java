package quiz21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileQuiz02 {

	public static void main(String[] args) {
		
		/*
		 * 1. 날짜클래스를 이용해서 file경로에 20250124.txt 이름으로 파일을 씁니다.
		 * 2. 내용은 "그만" 을 입력할 때 까지 작성해 주면 됩니다.
		 * 3. 파일을 썻다면, BufferedReader를 이용해서 파일의 내용을 읽어들이세요. 
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(date);

		String path = "C:\\Users\\user\\Desktop\\course\\java\\file\\" + now + ".txt";
		
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter( new FileWriter(path));
			br = new BufferedReader( new FileReader(path));

			while(true) {
				
				System.out.print(">>");
				String str = scan.nextLine();
				
				if(str.equals("그만")) break;
				
				str += "\r\n";
				bw.write(str);
				bw.flush(); //버퍼를 비운다
			}
			
			System.out.println("파일 입력이 완료되었습니다");
			System.out.println("--------------------");
			
			//입력
			String word;
			while( (word = br.readLine()) != null ) {
				System.out.println(word);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (Exception e2) {
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
