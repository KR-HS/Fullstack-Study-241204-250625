package quiz01;
import java.util.*;
public class Quiz15 {
	public static void main(String args[]) {
		/*
		 * 가로,세로 길이를 입력받습니다.
		 * 가로, 세로 길이의 사각형을 출력하면 됩니다.
		 * 단, 윤곽만 나타나도록 출력
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 > ");
		int width= sc.nextInt();
		System.out.print("세로 > ");
		int height = sc.nextInt();
		
		for(int i=1;i<=height;i++) {
			if(i==1|| i==height) {
				for(int j =1;j<=width;j++) {
					System.out.print("*");
				}
			}
			else {
				System.out.print("*");
				for(int j =2;j<=width-1;j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();

		}
		
		System.out.println("------------------");
		
		for(int i=1;i<=height;i++) {
			for(int j =1;j<=width;j++) {
				if(i==1|| i==height) {
					System.out.print("*");
				}
				else {
					if(j==1|| j==width) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}


			System.out.println();

		}
		sc.close();

		
	}
}
