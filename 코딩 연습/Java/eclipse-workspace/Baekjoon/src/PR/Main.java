package PR;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/10986
public class Main {

	static int N,M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ct = 0;
			
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			long sum = 0;
			
			int[] modCt = new int[M];

			modCt[0] = 1;
			
			for(int i=0;i<N;i++) {
				sum+=arr[i];
				long mod = sum%M;
				modCt[(int)mod]++;
			}
			
			long result = 0;
			for(int mod : modCt) {
				if(mod>=2)
					result += (long)mod * (mod-1) / 2;
			}
			
			bw.write(result+"\n");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}