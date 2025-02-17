package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack  = new Stack<>();
        
        Integer n = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<>();
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	qu.offer(Integer.parseInt(br.readLine()));
        }
        
        for(int i=1;i<=n;i++) {
        	stack.push(i);
        	list.add("+");
        	while(!stack.empty()) {
        		if(stack.peek()==qu.peek()) {
        			stack.pop();
        			list.add("-");
        			qu.poll();
        		}else break;
        	}
        }
        
        if(!stack.empty()) bw.write("NO"+"\n");
        else {
        	for(String s : list) {
        		bw.write(s+"\n");
        	}
        }
        
        bw.flush();
        br.close();
        bw.close();
	}
}

