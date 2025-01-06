package day03;

public class MultiForEx02 {
	public static void main(String args[]) {
		
		// 바깥 반복문에 따라서 안쪽 반복문의 회전수가 달라지는 경우.
		for(int i=1;i<=9;i++) {
			
			for(int j = 1;j<=i;j++) {
				
				System.out.println(i+ "-" + j);
			}
		}
		
		System.out.println("---------------------");
		// 조건이 바뀌는 for문
		/* 바깥 반복문 - 행
		 
		 * 
		 ** 
		 ***
		 ****
		 *****
		 
		 */
		int star= 5;
		for(int i=1;i<=star;i++) {
			for(int j =1;j<=star+1-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------");
		
		for(int i=1;i<=5;i++) {
			for(int j =5-i+1;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		for(int i=1;i<=5;i++) {
			for(int j =1;j<=5-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------");
		
		for(int i=1;i<=5;i++) {
			for(int j =1+1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int k=5-i+1;k>=1;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		       *
		 	  ***
		 	 *****
		 	*******
		   *********
		     
		 */
		System.out.println("-----------------");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i*2-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
