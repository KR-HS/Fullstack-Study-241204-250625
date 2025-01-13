package day07.inherit.good;
public class MainClass {
	public static void main(String args[]) {
		// 공통클래스(부모클래스)
		Person p = new Person();
		p.name="홍길동";
		p.age= 20;
		System.out.println(p.info());
		
		// 상속받은 자식클래스
		Student s = new Student();
		s.name="이순신";
		s.age=30;
		s.studentId="123123";
		System.out.println(s.info());
		
		// 상속받은 자식클래스
		Teacher t = new Teacher();
		t.name="홍길자";
		t.age=40;
		t.subject="역사";
		System.out.println(t.info());
		
	}
}
