package day02;

public class CastingEx02 {
	public static void main(String args[]) {
		/*
		 *  크기가 큰 타입을 작은 타입으로 저장할 때는 (type) 캐스팅을
		 *  이용해서 명시적으로 형변환을 진행해야 한다.
		 */
		int i = 65;
		char c = (char)i;
		short s = (short)i;
		
		float f= 3.14f;
		int j=(int)f;
		
		System.out.println(j);
		
		//주의할점
		int a = 256;
		byte b = (byte)a;
		System.out.println(b);
	}
}
