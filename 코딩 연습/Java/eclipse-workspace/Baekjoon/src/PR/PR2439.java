package PR;

import java.util.Scanner;

public class PR2439 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for(int i=0;i<N;i++){
			for(int j=1;j<N-i;j++){
				System.out.print(" ");               
			}
			for(int k=0;k<i+1;k++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		sc.close();
	}
}
