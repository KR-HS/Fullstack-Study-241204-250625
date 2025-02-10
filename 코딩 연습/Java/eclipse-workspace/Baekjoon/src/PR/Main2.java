package PR;
import java.io.*;
import java.util.Arrays;
import java.util.Stack;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<n;i++) {
			String input=br.readLine();
			if(input.length()>1) {
				String[] str= input.split(" ");
				int command = Integer.parseInt(str[0]);
				int num = Integer.parseInt(str[1]);
				if(command==1) s.push(num);
			}else {
				int command = Integer.parseInt(input);
				if(command==2) {
					if(!s.isEmpty()) bw.write(s.pop()+"\n");
					else bw.write(-1+"\n");
				}else if(command==3) bw.write(s.size()+"\n");
				else if(command==4) {
					if(s.isEmpty()) bw.write(1+"\n");
					else bw.write(0+"\n");
				}else if(command ==5) {
					if(!s.isEmpty()) bw.write(s.peek()+"\n");
					else bw.write(-1+"\n");
				}
			}
			
		}

		bw.flush();
		bw.close();
		br.close();
	}
}