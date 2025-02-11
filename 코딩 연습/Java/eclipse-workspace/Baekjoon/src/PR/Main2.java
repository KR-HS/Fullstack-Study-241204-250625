package PR;
import java.io.*;
import java.util.Arrays;
import java.util.Stack;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		Stack<Integer> s1 = new Stack<>();
		
		int count=1;
		
		for(String s: str) {
			int num = Integer.parseInt(s);
			if(num==count) {
				count++;
				while(s1.size()>0) {
					if(s1.peek()==count) {
						s1.pop();
						count++;
					}else break;
				}
				continue;
			}else {
				while(s1.size()>0) {
					if(s1.peek()==count) {
						s1.pop();
						count++;
					}else break;
				}
				s1.push(num);
			}
		}
		if(s1.size()==0) bw.write("Nice\n");
		else bw.write("Sad\n");
		bw.flush();
		bw.close();
		br.close();
	}
}