package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static int count=0;
	static int n;
	public static void hanoi(int n, int from, int to, int temp) throws IOException,NumberFormatException{
       if(n>0) {
    	   hanoi(n-1,from,temp,to);
    	   bw.write(from+" "+to+"\n");
//    	   count++;
    	   hanoi(n-1,temp,to,from);
       }
    }
	public static void main(String args[]) throws IOException,NumberFormatException{
		n = Integer.parseInt(br.readLine());
        
        int totalMoves = (int) Math.pow(2, n) - 1; // 최소 이동 횟수 계산
        
        bw.write(totalMoves+"\n"); // 총 이동 횟수 출력
        
        // 하노이의 탑 문제 해결
        hanoi(n, 1, 3, 2);
        
        bw.flush();
        bw.close();
        br.close();
        
        
	}
}

