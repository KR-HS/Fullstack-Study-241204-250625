package PR;
import java.io.*;
import java.util.*;

public class Main2 {	

	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
        	Deque<int[]> qu = new LinkedList<>();
        	
        	String[] str = br.readLine().split(" ");
        	int m = Integer.parseInt(str[0]);
        	int n = Integer.parseInt(str[1]);
        	int k = Integer.parseInt(str[2]);
        	
        	int[][] arr = new int[m][n];
        	boolean[][] visit=new boolean[m][n];
        	int[] dx= {1,0,-1,0};
        	int[] dy= {0,-1,0,1};
        	
        	for(int i=0;i<k;i++) {
        		String[] input = br.readLine().split(" ");
        		int x = Integer.parseInt(input[0]);
        		int y = Integer.parseInt(input[1]);
        		arr[x][y]=1;
        	}
        	int count=0;
        	for(int i=0;i<m;i++) {
        		for(int j=0;j<n;j++) {
        			if(arr[i][j]==1 && !visit[i][j]) {
        				qu.offer(new int[] {i,j});
        				visit[i][j]=true;
        				count++;
        			}
        			while(qu.size()>0) {
        				int[] pop = qu.pollFirst();
        				
        				for(int p=0;p<4;p++) {
        					int nx=pop[0]+dx[p];
        					int ny=pop[1]+dy[p];
        					if(nx>=0&&nx<m&&ny>=0&&ny<n) {
        						if(!visit[nx][ny] && arr[nx][ny]==1) {
        							qu.offer(new int[] {nx,ny});
        							visit[nx][ny]=true;
        						}
        					}
        				}
        			}
        			
        		}
        	}
        	bw.write(count+"\n");
        	t--;
        }
        bw.flush();
        bw.close();
        br.close();
	}
}

