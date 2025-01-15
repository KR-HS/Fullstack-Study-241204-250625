package quiz09;

public class Users {
	private String name;
	private int rrn;
	private int age;
	
	// 생성자
	Users(){
		
	}
	Users(String name, int rrn, int age){
		this.name = name;
		this.rrn = rrn;
		this.age = age;
	}
	
	// setter
	void setName(String name) {
		this.name=name;
	}
	
	void setRrn(int rrn) {
		this.rrn=rrn;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	// getter
	String getName() {
		return name;
	}
	
	int getRrn() {
		return rrn;
	}
	
	int getAge() {
		return age;
	}
	
}
