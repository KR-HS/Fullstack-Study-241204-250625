package day06;

public class Phone {
	
	String model;
	int price;
	String color;
	
	// 생성자 - 클래스명과 대/소문자 동일, 반환유형 x
	// 보통 초기값을 지정하는 작업
	Phone(){
		System.out.println("폰 생성자 호출됨1");
		model="늑대의유혹 가로본능";
		price=10000;
		color="검정";
	}
	Phone(int price){
		this.price=price;
		System.out.println("폰 생성자 호출됨2");
	}
	Phone(String model,String color){
		this.model=model;
		this.color=color;
		System.out.println("폰 생성자 호출됨3");
	}
	Phone(int price,String model,String color){
		this.model=model;
		this.color=color;
		this.price=price;
		System.out.println("폰 생성자 호출됨4");
	}
	void info() {
		System.out.println("---휴대폰 정보---");
		System.out.println("모델:"+model);
		System.out.println("가격:"+price);
		System.out.println("색상:"+color);
	}
}
