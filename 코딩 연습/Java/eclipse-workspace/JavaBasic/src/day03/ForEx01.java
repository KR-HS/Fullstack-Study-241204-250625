package day03;

import java.util.*;
public class ForEx01 {
	public static void main(String args[]) {
		for(int i=0;i<=10;i++) {
			System.out.println(i);
		}
		System.out.println("-----------------");
		// 반대로 돌아가는 for문
		for(int i=10;i>=1;i--) {
			System.out.println(i);
		}
		System.out.println("------------------");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int j =1 ;j<=9;j++) {
			System.out.println(N+" * "+j+" = "+(N*j));
		}
	}
}
