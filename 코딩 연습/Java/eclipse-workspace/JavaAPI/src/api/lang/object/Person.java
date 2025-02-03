package api.lang.object;

public class Person implements Cloneable {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	

	//toString - 멤버변수를 문자열로 보여주도록 오버라이딩 많이함
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	//equals - 멤버변수가 동일하면 true반환하도록
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Person ) {
			Person p = (Person)obj;
			//p가 가진 name과 나의 name을 비교
			String name = p.getName();
			if( name.equals(this.name) ) {
				return true;
			}
		}
		return false;
	}
	
	//clone메서드 오버라이딩
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//finalize 오버라이딩
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this.name + "님이 소멸했습니다");
		super.finalize();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
