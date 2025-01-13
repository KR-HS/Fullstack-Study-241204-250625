package day07.override.basic2;

public class Employee extends Person{

	String department;
	
	@Override
	String info() {
		return "이름:"+name+", 나이:"+age+", 부서:"+department;
	}
}
