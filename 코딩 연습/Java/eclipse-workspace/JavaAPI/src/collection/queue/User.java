package collection.queue;

public class User implements Comparable<User> {

	private String name;
	private int age;
	
	public User() {
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(User o) {
		
		//String name = o.getName();
		//return this.name.compareTo(name); //이름 기준으로 오름차순
		//return name.compareTo(this.name); //이름 기준으로 내림차순
		
		//숫자 비교
		int age = o.getAge();
		//return Integer.compare(this.age, age); //나이 기준으로 오름차순
		return Integer.compare(age, this.age); //나이 기준으로 내림차순
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
	
	
}
