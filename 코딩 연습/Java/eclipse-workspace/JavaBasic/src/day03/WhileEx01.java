package day03;

public class WhileEx01 {
	public static void main(String args[]) {
		
		int a = 1; // 제어변수 - 반복문의 횟수 제어
		int sum =0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		while(a<=10) {
			
			sum+=a;
			a++; // 제어변수 조작으로 언젠가, 조건이 false되도록 만들어줌.
		}
		System.out.println("반복종료");
		System.out.println("합계 : "+sum);
		
		
		
	}
}
