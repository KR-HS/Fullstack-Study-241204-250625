package day05;

// 설계 클래스는 메인 메서드를 만들지 않음.
public class Pen {
	// 정의할 때 무엇이 정의되는가
	// 멤버변수(전역변수)(필드) - 클래스의 속성을 나타낼때 사용
	
	String ink;
	int price;
	String company;
	
	// 메서드 - 클래스내의 기능
	void write() {
		System.out.println(ink+"색상 글씨입니다.");
	}
	
	String info() {
		System.out.println("---펜의 사용 정보---");
		System.out.println("색상 :"+ink);
		System.out.println("가격 :"+price);
		System.out.println("제조사:"+company);
		
		return "색상: "+ ink+", 제조사 :"+company;
	}
	
	
}
