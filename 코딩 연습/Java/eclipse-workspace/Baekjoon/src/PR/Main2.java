package PR;
import java.util.*;
import java.io.*;
public class Main2 {
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[n][2];
		
		for(int i=0;i<n;i++) {
			String[] str = sc.nextLine().split(" ");
			arr[i][0]=Integer.parseInt(str[0]);
			arr[i][1]=Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr,(o1,o2)->{
				if(o1[0]==o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
		});
	
		
		for(int[] ar:arr) {
			System.out.println(Arrays.toString(ar));
//			System.out.println(ar[0]+" "+ar[1]);
		}
		
		sc.close();
		
	}
}
