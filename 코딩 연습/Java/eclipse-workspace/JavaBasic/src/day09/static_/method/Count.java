package day09.static_.method;

public class Count {

	public int a; // 일반 멤버 변수
	public static int b; // 정적 멤버 변수
	
	// 일반 메서드
	// 일반변수, 정적변수 모두 사용 가능
	public int method01() {
		a=10;
		return ++b;
	}
	
	//정적 메서드
	// static 멤버들만 접근 가능
	// 단, 객체 생성을 통해 일반 멤버 접근 가능
	public static int method02() {
		// a=10;  // 오류
		Count c = new Count();
		c.a=1;
		
		
		return ++b;
	}
}
