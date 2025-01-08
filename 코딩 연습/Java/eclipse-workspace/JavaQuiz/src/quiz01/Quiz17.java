package quiz01;
import java.util.*;

public class Quiz17 {
	public static void main(String args[]) {
		/*
		 * 랜덤한 1~100사이의 수로 문제를 생성하고, 정답 맞추기 프로그램
		 * 
		 * 
		 * 1. 0을 입력하면 종료
		 * 2. 종료될때는 정답, 오답 개수 출력
		 */
		Scanner sc = new Scanner(System.in);
		int ct= 0; // 정답개수
		int ms= 0; // 오답개수
		
		
		for(;;) {
			int a=(int)(Math.random()*100)+1; // 1~100까지의 정수 정답 랜덤생성
			int b=(int)(Math.random()*100)+1; // 1~100까지의 정수 정답 랜덤생성
			System.out.println(a+" + "+b+" = ?");
			System.out.println("[문제를 그만 푸시려면 0을 입력하세요.]");
			System.out.print(">");
			int input= sc.nextInt();
			if(input==0) {
				System.out.println("프로그램 정상 종료");
				break;
			}
			if(input==(a+b)) ct++;
			else ms++;
		}
		System.out.println("정답 : "+ct);
		System.out.println("오답 : "+ms);
		sc.close();
	}
}
