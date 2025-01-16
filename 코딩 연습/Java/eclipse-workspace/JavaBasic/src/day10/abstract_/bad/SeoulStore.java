package day10.abstract_.bad;

public class SeoulStore extends Store{

	
	// 오버라이드
	public void apple() {
		System.out.println("서울지점의 사과는 500원 입니다.");
	}
	
	public void melon() {
		System.out.println("서울지점의 멜론은 500원 입니다.");
	}
}
