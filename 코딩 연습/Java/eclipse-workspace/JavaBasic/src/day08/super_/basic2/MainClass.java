package day08.super_.basic2;
public class MainClass {
	public static void main(String args[]) {
		Student s = new Student("홍", 20,"1234");
		System.out.println(s.info());

		//teacher, Employee도 생성자를 만들고, 객체 생성.
		Teacher t = new Teacher("길", 30,"수학");
		System.out.println(t.info());
		Employee e = new Employee("동", 40,"제품개발");
		System.out.println(e.info());
		
		
	}
}
