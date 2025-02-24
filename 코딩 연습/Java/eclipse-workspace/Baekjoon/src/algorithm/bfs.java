package algorithm;
import java.io.*;
import java.util.*;

public class bfs {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        int ct = Integer.parseInt(br.readLine());
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 그래프 값 넣기
        for(int i=0;i<ct;i++) {
        	String[] input = br.readLine().split(" ");
        	int first=Integer.parseInt(input[0]);
        	int second=Integer.parseInt(input[1]);
        	map.putIfAbsent(first, new ArrayList<>());
        	map.putIfAbsent(second, new ArrayList<>());
        	if(!map.get(first).contains(second)) map.get(first).add(second);
        	if(!map.get(second).contains(first)) map.get(second).add(first);
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> qu = new LinkedList<>();
        
        // 1번 노드에서 시작
        qu.offer(1);
        visited.add(1);
        
        // bfs탐색
        while(!qu.isEmpty()) {
        	int node = qu.poll();
        	
        	for(int n_node:map.getOrDefault(node,new ArrayList<>())) {
        		if(!visited.contains(n_node)) {
        			qu.offer(n_node);
        			visited.add(n_node);
        		}
        	}
        }
        
        bw.write(visited.size()-1+"\n");
        bw.flush();
        br.close();
        bw.close();
	}
}

