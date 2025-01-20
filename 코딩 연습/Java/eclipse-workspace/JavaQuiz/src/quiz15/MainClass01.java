package quiz15;
import java.util.*;
public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * 1. 스캐너를 통해서 정수 2개를 입력받습니다.
		 * 2. 입력받은 값이 정수라면 , 단순히 정수의 합을 출력하고 반복문을 종료하세요
		 * 3. 입력받은 값이 에러를 발생시키는 값이라면 "정수로만 입력하세요" 를 출력한 후에 다시 입력받습니다.
		 * 4. 반복문을 탈출하면 프로그램 정상 종료 문장을 띄워주세요.
		 * 
		 * * 예외처리를 정상적으로 하면, 무한루프에 빠지게 됩니다.
		     이유는 "구글"에 검색해서 적절히 처리해 보세요.
		 *
		 *
		 */

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("첫번째 정수입력>>");
				int a = sc.nextInt();
				System.out.print("두번째 정수입력>>");
				int b = sc.nextInt();
				
				System.out.println(a+b);
				break;
			}catch(Exception e) {
				System.out.println("정수로만 입력하세요");
				// next(), nextInt()사용후에는 버퍼에 개행문자("\n")이 남아있기 때문에 
				// nextLine()을 통해 버퍼에 남아있는 개행문자("\n")를 소모 시킨후 다음 값을 받음.
				// 
				sc.nextLine();
			}
		}
		System.out.println("프로그램 정상 종료");
	}
}
