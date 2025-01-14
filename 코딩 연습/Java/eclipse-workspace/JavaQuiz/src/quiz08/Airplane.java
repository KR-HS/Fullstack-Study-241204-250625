package quiz08;

public class Airplane { 
	//부모클래스는 변경하지 않습니다.
	String name;

	Airplane(String name) {
		this.name = name;
	}

	void takeOff() {
		System.out.println("비행기가 이륙합니다.");
	}
	
	void fly() {
		System.out.println("일반 모드로 비행합니다.");
	}
	
	void land() {
		System.out.println("비행기가 착륙합니다.");
	}
}






