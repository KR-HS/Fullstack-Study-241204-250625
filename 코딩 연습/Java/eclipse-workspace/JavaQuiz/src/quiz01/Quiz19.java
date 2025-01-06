package quiz01;
import java.util.*;
public class Quiz19 {
	public static void main(String[] args) {
		//백준 - 배열 x보다 작은 수
		// https://www.acmicpc.net/problem/10871
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}
		
		for(int a : A) {
			if(a<X){
				System.out.print(a+" ");
			}
		}
	}
}
