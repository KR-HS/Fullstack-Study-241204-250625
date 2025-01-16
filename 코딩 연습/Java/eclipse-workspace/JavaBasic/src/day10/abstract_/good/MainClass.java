package day10.abstract_.good;

public class MainClass {
	public static void main(String[] args) {
		
		/*
		 * 추상 클래스 - 다형성을 사용할 수 있게 해주는 방법
		 * > 자식에서 반드시 오버라이드가 들어가기 때문
		 * 
		 * 추상메서드 - 자식클래스에서 오버라이딩을 강제화 하게 됨
		 */
		
		Store s = new SeoulStore();
		
		System.out.println(s.storeName);
		s.melon();
		s.apple();
		s.orange();
		s.grape();
		s.mango();
		
		System.out.println("-".repeat(30));
		
		BusanStore b = new BusanStore();
		System.out.println(b.storeName);
		b.melon();
		b.apple();
		b.orange();
		b.grape();
		b.mango();

	}
}
