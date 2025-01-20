package quiz17;

import java.lang.*;
import java.util.*;
import java.math.*;
public class StringQuiz02 {
	public static String reverse(String str) {
		String rev_str="";
		for(int i=str.length()-1;i>=0;i--) {
			rev_str+=str.charAt(i);
		}
		
		return rev_str;
	}
	
	
	public static void main(String[] args) {
		/*
		 * 문자열 거꾸로 뒤집기
		 * 
		 * 매개 변수로 전달받은 문자열을, 거꾸로 뒤집어서 반환하는 메서드를 생성하세요
		 * 
		 * reverse(String)
		 * 입력 -> abcde
		 * 반환 -> edcba
		 */
		BigInteger b = new BigInteger("2");
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력>>");
		String input = sc.nextLine();
		// StringBuffer 사용
		StringBuffer sb = new StringBuffer();
		sb.append(input);
		sb.reverse();
		System.out.println("StringBuffer값: "+ sb);
		
		// 사용자 메서드 사용
		System.out.println("사용자 메서드 값: "+ reverse(input));
	}
}
