package collection.queue;

/**
 * 
 */
public class User implements Comparable<User>{
	private String name;
	private int age;
	
	@Override
	public int compareTo(User u) {
		
		// 숫자비교
		// Wrapper클래스에 compare메서드
		int age = u.getAge();
		return Integer.compare(this.age, age); // 나이 기준 오름차순
//		return Integer.compare(age, this.age); // 나이 기준 내림차순
		
//		String name= u.getName();
//		return this.name.compareTo(name); // 이름기준 오름차순
//		return name.compareTo(this.name); // 이름기준 내림차순
	};
	
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

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
