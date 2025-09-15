package PR;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/2565
public class Main {

	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
		
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			int len1 = str1.length();
			int len2 = str2.length();
			
			int[][] dp = new int[len1+1][len2+1];
			
			for(int i=0;i<len1;i++) {
				for(int j=0;j<len2;j++) {
					if(str1.charAt(i)==str2.charAt(j)) {
						dp[i+1][j+1] = dp[i][j] + 1; 
					}else {
						dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
					}
				}
			}
			
			bw.write(dp[len1][len2]+"\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

