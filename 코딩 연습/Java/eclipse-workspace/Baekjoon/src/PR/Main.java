package PR;
import java.io.*;
import java.util.*;
public class Main {
	 
	public static int[][] BuildMap(BufferedReader br, int n, int m) throws IOException{
		int[][] map = new int[n][m];
			 
		for(int i=0;i<n;i++) {
			 String line = br.readLine();
			 map[i] = line.chars().map(c -> c-'0').toArray();
		 }
			 
		return map;
	}
	
	
	public static int Solve(int[][] map){
		int n = map.length;
		int m = map[0].length;
		
		int[][] visited = new int[n][m];
		
		Queue<int[]> qu = new LinkedList<>();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		 
		qu.add(new int[] {0,0});
		visited[0][0] = 1;
		
		while(!qu.isEmpty()) {
			 int[] q = qu.poll();
			 int x = q[0];
			 int y = q[1];
			 for(int j=0;j<4;j++) {
				 int nx = x+dx[j];
				 int ny = y+dy[j];				 
				 if(nx<0 || nx >= n || ny < 0 || ny >= m || map[nx][ny]==0 || visited[nx][ny]!=0) continue;
				 qu.add(new int[] {nx,ny});
				 visited[nx][ny]=visited[x][y]+1;
				 
			 }
		 }
		
		
		return visited[n-1][m-1]; 
	}
	
	 public static void main(String args[]) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int[] nm = Arrays.stream(br.readLine().split(" ")).
				 mapToInt(Integer::parseInt).
				 toArray();
		 int[][] map = BuildMap(br,nm[0],nm[1]);
		 
		 
		 br.close();
		 bw.write(Solve(map)+"\n");
		 bw.flush();
		 bw.close();
	 }
}
