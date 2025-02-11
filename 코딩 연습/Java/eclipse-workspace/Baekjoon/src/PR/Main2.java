package PR;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			if(str.length>1) {
				q.offer(Integer.parseInt(str[1]));
				continue;
			}
			
			if(str[0].equals("front")) {
				if(q.size()<1) {
					bw.write(-1+"\n");
				}else bw.write(q.peekFirst()+"\n");
				continue;
			}
			else if(str[0].equals("back")) {
				if(q.size()<1) {
					bw.write(-1+"\n");
				}else bw.write(q.peekLast()+"\n");
				continue;
			}
			else if(str[0].equals("empty")) {
				if(q.size()<1) {
					bw.write(1+"\n");
				}else bw.write(0+"\n");
				continue;
			}
			else if(str[0].equals("size")) {
				bw.write(q.size()+"\n");
				continue;
			}
			else if(str[0].equals("pop")) {
				if(q.size()<1) {
					bw.write(-1+"\n");
				}else bw.write(q.pollFirst()+"\n");
				continue;
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}