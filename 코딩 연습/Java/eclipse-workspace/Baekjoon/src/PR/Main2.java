package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void hanoi(int n, int from, int to, int aux) throws IOException,NumberFormatException{
        // 원판이 하나일 경우, 바로 이동
        if (n == 1) {
            bw.write(from + " " + to+"\n");
            bw.flush();
            return;
        }
        
        // 1. n-1개의 원판을 from -> aux로 이동
        hanoi(n - 1, from, aux, to);
        
        // 2. 가장 큰 원판을 from -> to로 이동
        bw.write(from + " " + to+"\n");
        
        // 3. n-1개의 원판을 aux -> to로 이동
        hanoi(n - 1, aux, to, from);
    }
	public static void main(String args[]) throws IOException,NumberFormatException{
        int n = Integer.parseInt(br.readLine());
        int totalMoves = (int) Math.pow(2, n) - 1; // 최소 이동 횟수 계산
        
        bw.write(totalMoves+"\n"); // 총 이동 횟수 출력
        
        // 하노이의 탑 문제 해결
        hanoi(n, 1, 3, 2);
        
        
        
        
	}
}

