package PR;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static int[] dp;
	
	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			int n = Integer.parseInt(br.readLine());
			dp = new int[n];
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			dp[0]= arr[0];
			int maxSum = arr[0];
			
			for(int i=1;i<n;i++) {
				dp[i]= Math.max(arr[i], dp[i-1]+arr[i]);
				maxSum = Math.max(dp[i], maxSum);
			}
			
			bw.write(maxSum+"\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
