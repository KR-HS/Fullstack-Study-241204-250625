package day03;
import java.util.Scanner;
public class WhileEx03 {
	public static void main(String args[]) {
		// while조건은 다양한 형식으로 만들어 질 수 있음.
		// 어떤 수를 입력받아서, 이 수가 소수(약수가 1과 자기 자신인 수 )인지 확인
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수 입력 : ");
		int num = sc.nextInt();
		int i=2;
		while(i<num) {
			if(num%i==0) {
				System.out.println("소수가 아님");
				return;
			}
			i++;
			
		}
		System.out.println("소수임");
		sc.close();
	}
}
