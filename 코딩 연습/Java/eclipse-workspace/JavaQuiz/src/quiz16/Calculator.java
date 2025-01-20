package quiz16;
import java.util.*;
public class Calculator {
	
	public int input() throws Exception {		
		/*
		 * 
		 * 1. 정수 2개를 입력 받습니다.
		 * 2. 입력된 값이 정수라면 단순히 합계 반환
		 * 3. 예외가 발생하면, catch안에서 예외를 다시 한번 생성하고 throws처리합니다.
		 * 4. scan.close는 finally구문에서 처리.
		 */
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		try{
			System.out.println("입력>> ");
			a=sc.nextInt();
			b=sc.nextInt();
		}
		catch(Exception e){
			throw new Exception("정수값이 아닙니다.");
		}finally {
			sc.close();
		}
		return a+b;
	}
	

}
