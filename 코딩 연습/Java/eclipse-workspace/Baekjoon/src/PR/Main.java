package PR;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/10986
public class Main {

	static int N,M;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int i=0;i<N;i++) {
				for(int j=1;j<N;j++) {
					arr[i][j]=arr[i][j]+arr[i][j-1];
				}
			}
			
			
			for(int i=0;i<M;i++) {
				int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int result = 0;
				int x1 = input[0];
				int x2 = input[2];
				int y1 = input[1];
				int y2 = input[3];
				
				for(int j=x1-1;j<x2;j++) {
					if(y1==1) {
						result+=arr[j][y2-1];
						continue;
					}
					result+=(arr[j][y2-1]-arr[j][y1-2]);
				}
				
				bw.write(result+"\n");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}