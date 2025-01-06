package quiz01;
import java.util.*;


// https://www.acmicpc.net/problem/2439
public class Quiz14 {
	public static void main(String args[]) {
		
		Scanner sc  = new Scanner (System.in);
		System.out.print("입력 : ");
		int star = sc.nextInt();
		
		for(int i=1;i<=star;i++) {
			for(int j =star-i;j>=1;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
