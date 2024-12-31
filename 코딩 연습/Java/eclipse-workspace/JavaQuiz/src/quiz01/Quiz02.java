package quiz01;

public class Quiz02 {

	public static void main(String[] args) {
		//문제1 
		//랜덤한수 1~100이 주어질 떄, 이값이 5의 배수인지 확인하고 출력
		
		int num=(int)(Math.random()*100)+1;
		System.out.println(num);
		System.out.println(num%5==0?"5의배수":"5의배수가아님");
		System.out.println("---------------------------------------");
		// 문제2
		// 랜덤한 정수 -5~5가 주어질 떄, 언제나 이값을 절대값으로 출력
		int num1=(int)(Math.random()*11)-5;
		System.out.println(num1);
		System.out.println(num1>=0?num1:-num1);
		System.out.println(Math.abs(num1));
		
		System.out.println("---------------------------------------");	
		//문제3
		//1~150까지 랜덤한 정수의 사과의 개수가 주어집니다.
		//사과를 담는 바구니의 크기 bucket이 주어질 때, 필요한 bucket의 개수를 구하세요.
		//예) 사과개수 100 -> 필요한 bucket의 수 10개
		//    사과개수 101 -> 필요한 bucket의 수 11개
		int bucket = 10;
		
		int apple = (int)(Math.random()*150)+1;
		System.out.println("사과개수:"+apple);
		System.out.println(apple%bucket==0?apple/bucket:apple/bucket+1);
		
		
	}
}
