package day09.static_.method;

public class MainClass {

	public static void main(String args[]) {
		
		// Count c = new Count();
		// c.a=1;
		MainClass m = new MainClass();
		m.example();
		// static멤버는 객체 생성 없이 접근 가능
		Count.b=1;
		Count.method02();
	}
	
	public void example() {
		System.out.println("hello world");
	}
}
