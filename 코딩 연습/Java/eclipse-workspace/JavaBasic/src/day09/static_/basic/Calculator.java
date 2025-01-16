package day09.static_.basic;

public class Calculator {
	
	/*
	 * 객체별로 결과값, color는 서로 다르기 때문에 일반변수가 됨
	 * 
	 * 객체에서 동일한 값을 가지는 변수는 static으로 쓰는게 좋음
	 */
	private String color;
	private int result;
	public static double pi=3.14;
	
	static {
		// 정적 초기화자 - 클래스가 load될때 단한번 실행됨
		pi=3.14;
		System.out.println("정적 초기화자 실행!");
	}
	
	
	
	
	/*
	 * 일반 변수를 사용하는 메서드는 일반메서드로 생성
	 */
	//setter
	public void setColor(String color) {
		this.color=color;
	}
	
	//getter
	public String getColor() {
		return color;
	}
	
	/*
	 * 일반 멤버변수를 쓰지 않고, 범용성 있게 사용할 메서드는
	 * static으로 선언하는게 좋음
	 */
	public static double circle(int radius) {
		return radius*radius*pi;
	}
	
}
