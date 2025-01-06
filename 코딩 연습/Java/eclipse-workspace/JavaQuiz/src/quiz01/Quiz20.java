package quiz01;
import java.util.*;
public class Quiz20 {
	public static void main(String args[]) {
		
		// 백준
		// https://www.acmicpc.net/problem/10818
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int min=arr[0];
		int max=arr[0];
		
		for(int ar:arr) {
			if(ar<min) min=ar;
			if(ar>max) max=ar;
		}
		System.out.println(min+" "+max);
	}
}
