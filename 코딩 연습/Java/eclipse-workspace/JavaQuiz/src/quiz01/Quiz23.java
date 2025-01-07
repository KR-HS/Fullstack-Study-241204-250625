package quiz01;
import java.util.*;
public class Quiz23 {
	public static void main(String args[]) {
		// 백준 2차원 배열 -2566
		// https://www.acmicpc.net/problem/2566
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];

		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int max=arr[0][0];
		int row=1;
		int col=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(max<arr[i][j]) {
					max=arr[i][j];
					row=i+1;
					col=j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row+" "+col);
		
		
	}
}
