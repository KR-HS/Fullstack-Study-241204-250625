package day07.inherit.good;

public class Person {
	// 공통클래스(부모 클래스) 
	String name;
	int age;
	
	String info() {
		return "이름:" +name+", 나이:"+age;
	}
}
