package day02;

public class CastingEx03 {
	public static void main(String args[]) {
		
		// 'A' = 65		
		// 1. 크기가 서로 다른 타입에 연산에서는 큰 타입에 맞추어 자동 형변환됨.		
		char c= 'C';
		int i=2;
		
		char cc= (char)(i+c);
		int ii=i+c;
		
		System.out.println(cc);
		System.out.println(ii);
		
		// 2. int형 보다 작은 타입의 연산 결과는 무조건 int가 된다.		
		byte b1 = 100;
		byte b2 = 10;
		byte b3 = (byte)(b1+b2);
		System.out.println(b3);
		
		short s1 = 100;
		byte b4 = 10;
		short s4 = (short)(s1+b4);
		System.out.println(s4);
		
		System.out.println('A'+10);
	
	}
}
