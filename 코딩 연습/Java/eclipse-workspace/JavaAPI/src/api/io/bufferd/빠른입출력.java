package api.io.bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class 빠른입출력 {

	public static void main(String[] args) {
		
		//System.out.println( ); //출력
		//Scanner scan = new Scanner(System.in); //입력
		
		/*
		 * 빠른 입출력에서는
		 * InputStreamReader
		 * OutputStreamWriter 클래스를 사용합니다.
		 */
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			System.out.print(">");
			String input = br.readLine();
			
			//입력받은 내용을 출력함
			bw.write(input);
			bw.flush();
			
			//클로즈
			br.close();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
		
		
		
		
		
		
		
		
	}
	
}
