package PR;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

	static List<Integer>[] list;
	
	static void bfs(BufferedWriter bw, int n,int v) throws IOException{
		Queue<Integer> qu = new LinkedList<>();
		boolean[] checked = new boolean[n+1];

		
		qu.add(v);
		checked[v]= true;
		
		
		while(!qu.isEmpty()) {
			int target = qu.poll();
			bw.write(target+" ");
			
			
			for(int li : list[target]) { 
				if(!checked[li]) {
					qu.add(li);
					checked[li] = true;
				}
			}
			
		}
		bw.write("\n");
	}
	
	static void dfs(BufferedWriter bw, int n,int v) throws IOException{
		boolean[] checked = new boolean[n+1];
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int pop = stack.pop();
			if(checked[pop]) continue;
			checked[pop] = true;
			bw.write(pop+" ");

			
			for(int i=list[pop].size()-1;i>=0;i--) {
				if(!checked[list[pop].get(i)]) stack.push(list[pop].get(i));
			}

		}
	
		bw.write("\n");

	}
	
	
	static int solve(BufferedWriter bw, BufferedReader br, int n, int m,int v) throws IOException{
		list = new ArrayList[n+1];
		
		// 배열 초기화
		for(int i=1;i<=n;i++) list[i] = new ArrayList<>();
		
		
		// 값 넣기
		for(int i=0;i<m;i++) {
			String[] input = br.readLine().split(" ");
			int in1 = Integer.parseInt(input[0]);
			int in2 = Integer.parseInt(input[1]);
			
			list[in1].add(in2);
			list[in2].add(in1);
			
		}
		
		// 정렬
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		

		
		dfs(bw,n,v);
		bfs(bw,n,v);
		
		return 0;
		
	}
	
	
	 public static void main(String args[]) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		  
		 int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		 
		 
		 
		 solve(bw, br,nm[0],nm[1],nm[2]);
		 br.close();
		 bw.flush();
		 bw.close();
	 }
}
