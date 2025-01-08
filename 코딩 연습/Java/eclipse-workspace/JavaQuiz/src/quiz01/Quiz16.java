package quiz01;

import java.util.*;

public class Quiz16 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 어떤 수를 입력받아서, 입력 받은 수 까지의 모든 소수들의 합계
		 */
		System.out.print("입력 : ");
		int N=sc.nextInt();
		
		if(N<2) {
			System.out.println("소수의 합 : "+ 0);
			return;
		}
		if(N==2) {
			System.out.println("소수의 합 : "+2);
			return;
		}
		
		int sum=2;		
		outerloop:for(int i=3;i<=N;i++) {
			for(int j=2;j<i;j++) {
				if(i%j==0) continue outerloop;
			}
			sum+=i;
		}
		System.out.println("소수의 합 : " + sum);
		sc.close();
	}
}
