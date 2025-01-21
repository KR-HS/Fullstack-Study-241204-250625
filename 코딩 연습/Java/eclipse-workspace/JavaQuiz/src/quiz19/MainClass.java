package quiz19;

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 1. 스캐너를 통해서 nextLine() 문장을 받습니다.
		 * 2. 입력된 문자열을 토크나이저를 이용해서 공백기준으로 분리
		 * 3. 분리한 토큰의 개수를 출력하고
		 * 4. 분리된 토큰을 콘솔에 숫자를 붙여서 세로로 출력해 주세요
		 *    1. 안녕
		 *    2. 하세요.
		 *    3. 오늘은 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		StringTokenizer token = new StringTokenizer(s);
		System.out.println(token.countTokens());
		int count=1;
		while(token.hasMoreTokens()) {
			System.out.println(count+". "+token.nextToken());
			count++;
		}
		sc.close();
	}
}
