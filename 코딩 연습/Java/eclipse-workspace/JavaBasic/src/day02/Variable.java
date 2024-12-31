package day02;

public class Variable {
	public static void main(String args[]) {
		
		/*
		 * 변수의 선언 방법
		 * 데이터타입 이름;
		 * 
		 * 
		 * int는 정수를 저장하는 대표적인 유형
		 */
		
		int a; // 변수 선언
		a=10;  // 변수초기화
		
		System.out.println(a);
		
		int a2 = 30; // 변수의 선언과 초기화 동시에
		//	int a =30;  동일한 이름으로 변수를 생성할 수 없음.
		
		int b =a+a2+30;
		b=100;
		
		System.out.println(b);
		
		String d = "문자";
	}
}
