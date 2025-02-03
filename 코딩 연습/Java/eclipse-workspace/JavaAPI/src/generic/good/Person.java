package generic.good;

public class Person<T> { //클래스 or 인터페이스에 <타입> 제네릭
	//Person에 전달되는 매개변수(제네릭) - 아직 타입은 정해지지 않음
	
	private T t;
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	
	
	
	
	
	
}
