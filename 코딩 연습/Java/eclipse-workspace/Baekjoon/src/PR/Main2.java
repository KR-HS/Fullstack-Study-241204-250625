package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	static int[] dp = new int[50001];
	
	public static void getDp(int n) {
		for(int i=1;i<=n;i++) {
			if(dp[i]!=0) continue;
			int N =(int)Math.sqrt(i);
			
			int count=5;
			if(i==(int)(Math.pow(N,2))) { 
				dp[i]=1;
			}else {
				while(N>0) {
					if(count>dp[(int)(Math.pow(N,2))]+dp[i-(int)(Math.pow(N,2))]) {
						dp[i]=dp[(int)(Math.pow(N,2))]+dp[i-(int)(Math.pow(N,2))];
						count=dp[i];
					}
					N--;
				}
			}
		}
	}
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        getDp(n);
        
        bw.write(dp[n]+"\n");
        bw.flush();
        bw.close();
        br.close();
	}
}

