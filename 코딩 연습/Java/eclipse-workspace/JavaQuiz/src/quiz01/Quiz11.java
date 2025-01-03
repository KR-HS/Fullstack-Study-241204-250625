package quiz01;
import java.io.*;
import java.util.*;
public class Quiz11 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		/*
		 * 1. 첫째줄에 N정수가 주어집니다.
		 * 2. 이후부터는 N줄에 걸쳐서 정수를 입력받음.
		 * 이 입력받은 값을, 배열에 순서대로 저장
		 */
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		
//		
//		for(int i=0;i<N;i++) {
//			System.out.print("정수입력 >");
//			arr[i]=sc.nextInt();
//		}
//		sc.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int[] arr1 = new int[M];
		
		for(int j=0;j<M;j++) {
			arr1[j]=Integer.parseInt(br.readLine());
		}
		
		for(int ar1: arr1) {
			bw.write(ar1+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
