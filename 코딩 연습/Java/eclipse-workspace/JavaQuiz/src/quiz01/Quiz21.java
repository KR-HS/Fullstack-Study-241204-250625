package quiz01;
import java.util.*;

public class Quiz21 {
	public static void main(String args[]) {
		// 백준 - 10813
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		
		for(int k=0;k<m;k++) {
			int temp=0;
			int i=sc.nextInt();
			int j=sc.nextInt();
			
			temp=arr[i-1];
			arr[i-1]=arr[j-1];
			arr[j-1]=temp;
		}
		
		for(int a:arr) {
			System.out.print(a+" ");
		}
		
	}
}
