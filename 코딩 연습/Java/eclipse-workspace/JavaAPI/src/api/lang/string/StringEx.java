package api.lang.string;

import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) {
		
		String str = new String(new char[] {'h','e','l','l','o'});
		System.out.println(str);
		
		// 문자열 자르기
		char a = str.charAt(0);
		System.out.println(a);
		
		// 문자열 길이
		int n = str.length();
		System.out.println(n);
		
		// 문자열 찾기
		System.out.println("문자열 찾은 위치: "+ str.indexOf("l"));
		System.out.println("문자열을 3번 인덱스부터 찾은 위치:"+str.indexOf("l",3));
		System.out.println("문자열을 뒤에서부터 찾은 위치:"+str.lastIndexOf("l"));
		System.out.println("찾는 문자가 없으면 : "+str.indexOf("야")); //찾는 문자 없으면 -1 반환
		
		
		// 문자열 변경
		String b = "안녕하세요? 문자열은 문자의 합 입니다";
		
		String r2= b.replace("문자","word"); // 타켓문자, 바꿀문자
		System.out.println(r2); // 새로운 문자열을 반환
		System.out.println(b); // 원본 문자는 그대로
		
		// 원본 문자 변경
		b = b.replace("문자", "word");
		System.out.println(b);
		
		b= b.replace(" ","");
		System.out.println(b);
		
		// 대소문자 변경
		String c = "abcDEF";
		System.out.println(c.toUpperCase());
		System.out.println(c.toLowerCase());
		
		// 앞뒤 공백 제거 trim
		String d = " 오늘은 월요일 입니다  ";
		System.out.println(d.trim());
		
		// 문자열 자르기 substring
		String e = "자바칩 프라푸 치노";
		System.out.println(e.substring(4)); // 4미만 절삭
		System.out.println(e.substring(0,3)); // 0이상 3미만 추출
		
		// 문자열 비교
		System.out.println("홍길동".equals("홍길동"));
		
		System.out.println("홍길동".compareTo("홍길자")); // 음수가 나오면, 뒤에 있는 글자가 사전적으로 뒤에 있음
		System.out.println("홍길동".compareTo("홍길동")); // 같은 문자열
		System.out.println("홍길자".compareTo("홍길동")); // 양수가 나오면, 앞에 글자가 사전적으로 뒤에 있음
		
		// 문자열 자르기 split()
		String f = "010-1234-5678";
		String[] arr = f.split("-");
		System.out.println(Arrays.toString(arr));
		
		String[] arr2 = f.split(" ");
		System.out.println(Arrays.toString(arr2));
		
		// 문자열 자르기 toCharArray
		char[] arr3 = f.toCharArray();
		System.out.println(Arrays.toString(arr3));
		
		// 문자열 합치기
		String r = String.join("->", "java","is","cool");
		System.out.println(r);
	}
}
