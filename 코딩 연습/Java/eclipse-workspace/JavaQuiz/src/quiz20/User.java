package quiz20;

public class User {
	private String name;
	private int age;
	
	
	// 생성자
	public User() {
		
	}
	public User(String name,int age) {
		this.name= name;
		this.age = age;
	}
	
	// setter
	public void setName(String name) { 
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
