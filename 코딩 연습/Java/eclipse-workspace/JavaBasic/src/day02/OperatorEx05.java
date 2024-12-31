package day02;

public class OperatorEx05 {
	public static void main(String[] args) {
		
		// 프로그램에서 난수(랜덤값)
		System.out.println(Math.random()); // 0.0~1.0 미만의 실수 랜덤값
		double d = Math.random()*10; // 0에서 10미만''
		int r = (int)d+1; // 1~10
		System.out.println(r);
		
		//한줄로
		int ran= (int)(Math.random()*10)+1;
		System.out.println(ran);
		
		
		// 3항연산자
		// 1~100 랜덤수
		int x= (int)(Math.random()*100)+1;
		
		String result=x%2==0?"짝수":"홀수";
		
		System.out.println("랜덤수 "+x+"        "+result+"입니다.");
		
		// 계산 순서
		// 소괄호 > 단항 > 이항 > 삼함> 대입		
	}
}
