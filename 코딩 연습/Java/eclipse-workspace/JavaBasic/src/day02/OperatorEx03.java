package day02;

public class OperatorEx03 {
	public static void main(String[] args) {
		int x=10;
		int y= 20;
		
		// if문 소괄호가 true라면, if구문 실행
		if(x!=10 & ++y==21) {  //절대 만족할 수 없는 조건일 때 뒤를 실행하지 않음
			System.out.println("참입니다");
		}else {
			System.out.println("거짓입니다.");
		}
		
		System.out.println("x값:"+x);
		System.out.println("y값:"+y);
		
		
		if(x!=10 && ++y==21) {  //절대 만족할 수 없는 조건일 때 뒤를 실행하지 않음
			System.out.println("참입니다");
		}else {
			System.out.println("거짓입니다.");
		}
		
		System.out.println("x값:"+x);
		System.out.println("y값:"+y);
		
		
		//or
		if (x==10||++y==21) {
			System.out.println("참입니다.");
		}else {
			System.out.println("거짓입니다.");
		}
		
		System.out.println("x값: "+x);
		System.out.println("y값: "+y);
	}
}
