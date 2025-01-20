package quiz15;
import java.util.*;
public class MainClass02 {
	public static void main(String[] args) {
		/*
		updown게임			
		1~100사이의 정답이 주어지고, 사용자는 정답을 맞추는 게임입니다.
		정답보다, 입력값이 작다면 "더 큰 값을 입력하세요"
		정답보다, 입력값이 크다면 "더 작은 값을 입력하세요"
		를 출력합니다.
		
		정답을 맞추면, 정답횟수를 출력해주면 됩니다.
		잘못된 값을 입력한 경우에 에러처리를 하고, 정답횟수를 증가 시켜주세요.
				
		
		*/
		Scanner sc = new Scanner(System.in);
		int count=0;
		int answer=(int)(Math.random()*100)+1;
		while(true) {
			try {
				System.out.print("값을 입력하세요>>");
				int input=sc.nextInt();
				if(answer==input) {
					System.out.printf("정답입니다!(시도횟수:%d)\n",count);
					break;
				}
				else if(answer>input) {
					System.out.println("더 큰 값을 입력하세요.");
				}
				else {
					System.out.println("더 작은 값을 입력하세요.");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("잘못된 입력값입니다. 정답횟수를 누적합니다.");
			}finally {
				count++;
			}
		}
		System.out.println("프로그램 종료");
	}
}
