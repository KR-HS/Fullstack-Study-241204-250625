package day09.poly.instanceof_;

public class Employee extends Person{

	String department;
	
	Employee(String name, int age, String department){
		super(name,age);
		this.department=department;
	}
	@Override
	String info() {
		return super.info()+", 부서:"+department;
	}
}
