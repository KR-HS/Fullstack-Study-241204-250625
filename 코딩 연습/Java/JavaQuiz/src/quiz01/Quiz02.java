package quiz01;

public class Quiz02 {

	public static void main(String[] args) {
		//삼항연산식을 써야 할껄?
		
		//문제1 
		//랜덤한 -5~5 까지의 정수가 주어집니다.
		//항상 이값의 절대값(무조건 양수)를 출력해주세요.
		int num=(int)(Math.random()*11)-5;
		
		System.out.println(num);
		System.out.println(num>=0?num:-num);
		System.out.println(Math.abs(num));
		
		System.out.println("---------------------------------------");	
		//문제2
		//1~150까지 랜덤한 정수의 사과의 개수가 주어집니다.
		//사과를 담는 바구니의 크기 bucket이 주어질 때, 필요한 bucket의 개수를 구하세요.
		//예) 사과개수 100 -> 필요한 bucket의 수 10개
		//    사과개수 101 -> 필요한 bucket의 수 11개
		int bucket = 10;
		
		int apple = (int)(Math.random()*150)+1;
		System.out.println("사과개수:"+apple);
		System.out.println(apple%bucket==0?apple/bucket:apple/bucket+1);
		
		System.out.println("---------------------------------------");	
		//문제3
		//0~50 까지의 랜덤한 수가 주어질 때,
		// 이 값이 5의 배수라면, "5의 배수입니다", 5의 배수가 아니라면 "5의 배수가 아닙니다" 출력해주세요
		
		int num3=(int)(Math.random()*51);
		System.out.println(num3);
		System.out.println(num3!=0&&num3%5==0?"5의 배수입니다":"5의 배수가 아닙니다");
	}
}
