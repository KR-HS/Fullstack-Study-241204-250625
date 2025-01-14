package day08.super_.basic2;

public class Student extends Person{
	String studentId;
	
	Student(String name, int age, String studentId){
		//super()
		//this.name=name;
		//this.age=age;
		super(name,age);
		this.studentId = studentId;
		
	}
	@Override // 어노테이션 - 특정기능 표현
	String info() {
		return super.info()+", 학번:"+studentId;
	}

}