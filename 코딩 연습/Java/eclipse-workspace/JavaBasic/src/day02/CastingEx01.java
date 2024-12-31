package day02;

public class CastingEx01 {
	public static void main(String args[]) {
		
		/*
		 * 크기가 작은 타입을 큰 타입에 대입하면
		 * 자동 형변환
		 */
		byte b = 10;
		short c = b;  // byte -> short형 자동형변환
		int i = b; // byte -> int형 자동형변환
		long l = b; // byte -> long 자동형변환
	
		char cc = 'A';
		int ii=cc; // char -> int 자동형변환
		System.out.println(ii);
		
		int k=10;
		double d=k;
		System.out.println(d); // int ->double 자동 혈변환
	}
}
