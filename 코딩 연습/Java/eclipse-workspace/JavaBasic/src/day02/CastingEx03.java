package day02;

public class CastingEx03 {
	public static void main(String args[]) {
		
		char c ='A';
		int i=2;
		
		// 1. 서로 다른 타입에서 연산의 결과는 큰 타입을 따라간다.
		char cc = (char)(c+i);
		System.out.println(cc);
		
		int j =10;
		double d =3.14;
		int result = (int)(j+d);
		
		// 2. int형 보다 작은 타입의 연산결과는 항상 int가 된다.
		byte a = 10;
		byte b = 20;
		byte result2 = (byte)(a+b);
		
		System.out.println('A'+10); // char+int=int형
		System.out.println('A'+'B');// char+char=int형
	
		byte bb = 10;
		short ss= 20;
		short result3 = (short)(bb+ss);
		
	}
}
