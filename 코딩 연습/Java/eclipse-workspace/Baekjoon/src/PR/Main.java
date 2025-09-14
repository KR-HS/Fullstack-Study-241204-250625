package PR;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static int[][] dp; 
	static int MOD = 1000000000;
	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			int n = Integer.parseInt(br.readLine());
			
			dp = new int[n+1][10];
			Arrays.fill(dp[1], 1);
			dp[1][0]=0;
			for(int i=2;i<=n;i++) {
				for(int j=0;j<10;j++) {
					
					if(j-1 >= 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1])%MOD; 
					if(j+1 <= 9) dp[i][j] = (dp[i][j]+dp[i-1][j+1])%MOD;
				}
			}
			int sum=0;
			for(int num: dp[n]) {
				sum=(sum+num)%MOD;
			}
			
			bw.write(sum+"\n");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
