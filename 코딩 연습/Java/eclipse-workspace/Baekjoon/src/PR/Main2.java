package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	static boolean[][] answer;
    
    static void makeStar(int i, int j, int n) {
        if (n == 1) {
            answer[i][j] = true;
            return;
        }

        int k = n / 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (r == 1 && c == 1) continue;
                makeStar(i + r*k, j + c*k, k);
            }
        }
    }
    
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        answer = new boolean[n][n];
        
        makeStar(0,0,n);
        
       
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(answer[i][j]) bw.write("*");
        		else bw.write(" ");
        	}
        	bw.write("\n");
        }
        bw.flush();
       
        
        
        
	}
}

