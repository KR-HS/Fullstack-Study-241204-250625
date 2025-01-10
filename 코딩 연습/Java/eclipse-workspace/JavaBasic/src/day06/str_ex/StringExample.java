package day06.str_ex;

public class StringExample {
	public static void main(String[] args) {
		
		String str1 = "홍길자";
		String str2 = "홍길자";
		String str3= new String("홍길자");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		
		/*
		 * 같은 클래스에서 동일 문자열을 생성하면, 같은 주소를 바라보게 됨.
		 * 하지만, 직접 String객체 생성 명령을 내리거나 
		 * 다른 클래스에서 넘어온 String은 다른 주소를 가지게됨
		 * 
		 * 그래서 문자열 비교시에는 ==대신에 equals()메서들 사용해서 문자열 동등비교
		 * 
		 * equals() - 문자열 그자체를 비교해서 동일하면 true, 아니면 false
		 */
	}
}
