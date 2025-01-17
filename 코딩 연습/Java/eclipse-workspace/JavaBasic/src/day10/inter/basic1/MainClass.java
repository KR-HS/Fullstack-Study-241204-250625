package day10.inter.basic1;

public class MainClass {
	public static void main(String[] args) {
		
		Basic basic = new Basic();
		
		basic.method01();
		basic.method02();
//		System.out.println(basic.ABC);
		System.out.println(Basic.ABC);
		
		System.out.println("-".repeat(20));
		/*
		 * 인터페이스도 하나의 데이터 타입이 될수 있음.
		 * 
		 * 이때, 다형성으로 동작이 됨.
		 */
		Inter01 b = new Basic();
		b.method01();
		// b.method02();
		
		Inter02 b2 = new Basic();
		//b2.method01();
		b2.method02();

		// 인터페이스에서도 클래스 캐스팅을 할 수 있음.
		Basic bb = (Basic)b2;
		bb.method01();
		bb.method02();
	}
}
