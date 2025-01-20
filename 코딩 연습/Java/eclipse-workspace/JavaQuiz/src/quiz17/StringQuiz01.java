package quiz17;

import java.util.*;
public class StringQuiz01 {
	public static void main(String[] args) {
		
		/*
		 * 1. id문자열을 입력 받습니다.
		 * 2. 아이디는 공백을 포함해서 받을 수 있습니다.
		 * 3. 공백을 제외하고, 5글자 미만이면, 다시 입력받습니다.
		 * 4. 5글자 이상이라면 "id 등록"을 출력하고 종료
		 */
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.print("id입력>> ");
			String s = sc.nextLine();
			s=s.replace(" ","");
			if(s.length()<5) continue;
			
			System.out.println("아이디: "+s+" 등록");
			sc.close();
			return;
		}
	}
}
