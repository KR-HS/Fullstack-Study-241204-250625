package day09.poly.instanceof_;

public class Teacher extends Person{
	String subject;

	
	Teacher(String name, int age ,String subject){
		super(name,age);
		this.subject=subject;
	}
	@Override
	String info() {
		return super.info()+", 과목:"+subject;
	}
}