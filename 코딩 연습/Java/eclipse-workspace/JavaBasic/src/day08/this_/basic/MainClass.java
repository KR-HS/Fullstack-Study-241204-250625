package day08.this_.basic;
public class MainClass {
	public static void main(String args[]) {
		// 공통클래스(부모클래스)
		Person p = new Person("홍길동",20);
		Person p2 = new Person("홍길동");
		Person p3 = new Person();
		
		System.out.println(p.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
	}
}
