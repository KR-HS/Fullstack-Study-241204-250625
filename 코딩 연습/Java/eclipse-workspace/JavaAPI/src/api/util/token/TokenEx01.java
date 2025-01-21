package api.util.token;

import java.util.StringTokenizer;

public class TokenEx01 {
	public static void main(String[] args) {
		// StringTokenizer클래스 - 특정문자를 기준으로 잘라서 사용(split과 유사)
		String str1 = "오늘 날씨는 미세먼지가 많고, 매우 추워요";
		
		// 자르는 문자 기준이 주어지지 않는다면 공백을 기준으로 문자열을 자름
		StringTokenizer token1 = new StringTokenizer(str1);
		
		System.out.println(token1.countTokens()); // 잘린 문자의 개수
		
//		System.out.println(token1.nextToken());
//		System.out.println(token1.nextToken());
//		System.out.println(token1.nextToken());
//		System.out.println(token1.nextToken());
//		System.out.println(token1.nextToken());
//		System.out.println(token1.nextToken());
		
		// 다음이 있는지 확인하고 전진
		while(token1.hasMoreTokens()) { // 다음이 있으면 true, 없으면 false
			System.out.println(token1.nextToken());
		}
		
		System.out.println("-".repeat(30));
		
		String str2 = "2025/01/21/월요일/홍길동/서울시";
		StringTokenizer token2 = new StringTokenizer(str2,"/"); // 주어진 delimeter를 기준으로 문자열 자름
		
		
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}

		System.out.println("-".repeat(30));
		
		
		String str3 = "2025.01.21/월요일/홍길동,서울시,마포구,강남구";
		
		// ", . /" 기준으로 자름
//		StringTokenizer token3 = new StringTokenizer(str3,",./");
		
		// 구분자도 토큰에 포함시켜줌
		StringTokenizer token3 = new StringTokenizer(str3,",./",true);
		while(token3.hasMoreTokens()) {
			System.out.println(token3.nextToken());
		}
		
	}
}
