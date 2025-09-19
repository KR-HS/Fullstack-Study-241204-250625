package PR;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14888
public class Main {

	static int N;

	static int[][] S;
	
	static int[] team1;
	
	static int minVal=Integer.MAX_VALUE;
	static int allSum=0;
	
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			N = Integer.parseInt(br.readLine());
			
			S = new int[N][N];
			
			team1 = new int[N/2];
			
			for(int i=0;i<N;i++) {
				S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int num:S[i]) allSum+=num;
			}
			
			solve(0,0);
			
			bw.write(minVal+"\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void solve(int index,int ct) {
		if(ct==N/2) {
			int sum1 = 0;
			
			for(int i=0;i<ct-1;i++) {
				for(int j=i+1;j<ct;j++) {
					sum1+=(S[team1[i]][team1[j]]+S[team1[j]][team1[i]]);
				}
			}
			
			boolean[] isTeam1 = new boolean[N];
			
			for(int idx: team1) {
				isTeam1[idx] = true;
			}
			
			int sum2 = 0;
			
			for(int i=0;i<N-1;i++) {
				if(isTeam1[i]) continue;
				for(int j=i+1;j<N;j++) {
					if(isTeam1[j]) continue;
					
					sum2+=(S[i][j]+S[j][i]);
				}
			}
			
			int diff = Math.abs(sum1 - sum2);
			
			if(diff<minVal) minVal = diff;
			
			return;
		}
		
		for(int i=index;i<N;i++) {
			team1[ct] = i;
			solve(i+1,ct+1);
		}
	}
}