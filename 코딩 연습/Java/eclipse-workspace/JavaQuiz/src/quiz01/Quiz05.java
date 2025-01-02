package quiz01;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		/*
		 * 어떤 정수를 2개 입력 받습니다.
		 * A > B 큰 경우에는 A를 출력
		 * B > A 큰 경우네는 B를 출력
		 * A == B 같은 경우에는 "같은 수 입니다" 를 출력합니다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("A>");
		int a = scan.nextInt();
		System.out.print("B>");
		int b = scan.nextInt();
		
		if(a > b) {
			System.out.println(a);
		} else if(b > a) {
			System.out.println(b);
		} else { //같음
			System.out.println("같은 수 입니다");
		}
		
		scan.close();
		
		
		
		
	}
}
