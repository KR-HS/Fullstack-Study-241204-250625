package day07.override.basic;

public class Child extends Parent{
	
	@Override
	void method02() {
		System.out.println("자식에서 오버라이딩 한 2번 메서드 실행");
	}
}
