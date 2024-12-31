package day02;

public class DataTypeEx01 {
	public static void main(String args[]) {

		// 정수형 타입
		byte a = 127;
		byte a2 = -128;

		short b = 32767;
		short b2 = -32768;

		int c = 2147483647;
		int c2 = -2147483648;

		long d =123123123123123L; // 롱타입은 L을 붙인다.
		System.out.println(d);

		/*
		 * 2진수  - 숫자앞에 0b를 붙임
		 * 8진수  - 0을 붙임
		 * 16진수 - 0x를 붙임
		 * 형태로 저장가능
		 */
		int bin = 0b1010;
		System.out.println("이진수: 1010의 값은"+bin+"입니다.");

		System.out.println("---------------------------");

		//실수형 타입
		float f1 = 3.141592567f; // float타입은 값뒤에 f를 붙임.
		double d1 = 3.141592567;
		
		System.out.println(f1); // 소수점 7자리
		System.out.println(d1); // 소수점 15자리 - default
		
		//e표기법 - 실수부를 표현할 자리가 없으면 사용
		float f2 = 314.15e-2f;
		double d2 = 0.00031415e4;
		System.out.println(f2);
		System.out.println(d2);
		
		System.out.println("---------------------");
		
		// 논리형 타입
		boolean bool=true;
		boolean bool2= false;
		// boolean bool3 = True;
		
		
	}
}
