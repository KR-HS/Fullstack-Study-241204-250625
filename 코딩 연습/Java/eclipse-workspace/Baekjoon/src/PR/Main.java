package PR;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/9663
public class Main {

	static int N;

	static boolean[] colc;
	static boolean[] diag1;
	static boolean[] diag2;
	
	static int ct = 0;
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			N = Integer.parseInt(br.readLine());
			
			colc = new boolean[N+1];
			diag1 = new boolean[2*N]; // 우상, 좌하
			diag2 = new boolean[2*N]; // 좌상, 우하

			solve(0);

			bw.write(ct + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// depth = 행 수
	static void solve(int row) throws Exception {
		if (row == N) {
			ct++;
			return;
		}
		
		for(int col=0;col<N;col++) {
			if(colc[col] || diag1[col-row+N-1] || diag2[row+col]) continue;
			
			colc[col] = diag1[col-row+N-1] = diag2[row+col] = true;
			solve(row+1);
			colc[col] = diag1[col-row+N-1] = diag2[row+col] = false;
			
		}
	}
}
