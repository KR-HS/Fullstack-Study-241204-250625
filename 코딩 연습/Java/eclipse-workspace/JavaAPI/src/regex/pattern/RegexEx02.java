package regex.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx02 {
	public static void main(String[] args) {
		/*
		 * | - or
		 * () - 집합
		 * ? - 0~1회 나옴
		 * * - 0회 이상 나옴
		 * + - 1회 이상 나옴
		 * {4} - 4회 나옴
		 * {3,} - 3회 이상 나옴
		 * {3,5} - 3~5회 나옴
		 * 
		 * [0-9] - 0~9 사이의 문자 1개
		 * \\d  -  0~9 사이의 문자 1개
		 * 
		 * [a-zA-z가-힣] - 알파벳 or 한글 1개
		 * \\w - 영문자 숫자 1개 
		 * 
		 * 정규표현식에 사용되는 특수문자를 찾고 싶은 경우에는 \\를 붙이면 됩니다
		 */
		
		String info = "30세/홍길동/강남구/02-123-1234/010-1234-1234/aaA334@example.com";
		String pattern1="\\d{2,3}-\\d{3,4}-\\d{4}";
		
		Pattern p1=Pattern.compile(pattern1);
		Matcher m1= p1.matcher(info); // 적용할 문자열을 넣는다.
		
		/*
		 * find - 정규표현식을 찾음(찾으면 true, 없으면 false)
		 * group - 정규표현 문자열을 얻음
		 * start - 시작 위치
		 * end - 끝 위치
		 */
		
		while(m1.find()) { // 1번 수행시에 앞에서 한번 찾음
			System.out.println("정규표현식에 해당하는 문자를 찾음");
			System.out.println(m1.group());
			System.out.println("시작 위치 : "+m1.start()); 
			System.out.println("끝 위치 : "+m1.end());
		}
		
		System.out.println("-".repeat(30));
		
		// 이메일 형식
		String pattern2 = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+";
		
		Pattern p2 = Pattern.compile(pattern2);
		Matcher m2 = p2.matcher(info);
		while(m2.find()) {
			System.out.println("정규표현식에 해당하는 문자를 찾음");
			System.out.println(m2.group());
			System.out.println("시작 위치 : "+m2.start()); 
			System.out.println("끝 위치 : "+m2.end());
		}
		
		
	}
}
