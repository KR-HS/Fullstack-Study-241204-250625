package day07.override.basic;

public class MainClass {
	public static void main(String[] args) {
		Child c = new Child();
		c.method01();
		c.method02();
		
		String a = "1";
		a= 0+a;
		System.out.println(a);

	}
}
