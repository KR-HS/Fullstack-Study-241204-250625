package day03;
import java.util.Scanner;

public class WhileEx04 {
	public static void main(String args[]) {
		/*
		 * 첫째줄에 N의 개수가 주어진다.
		 * 그 다음줄 부터는 N번에 걸쳐서 입력을 받음
		 */
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		int i=1;
		while(i<=n) {
			int a = sc.nextInt();
			System.out.println(a);
			
			i++;
		}
		sc.close();
	}
}
