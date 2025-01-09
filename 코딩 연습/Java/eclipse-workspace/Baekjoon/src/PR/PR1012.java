package PR;
import java.util.*;
public class PR1012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k= sc.nextInt();
		int count=0;
		int[][] arr = new int[n][m];
		boolean isNear=false;
		for(int i=0;i<k;i++) {
			int col=sc.nextInt();
			int row=sc.nextInt();
			
			arr[row][col]=1;
		}
		
		int[] dx= {1,0,0,-1};
		int[] dy= {0,1,-1,0};
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					if(!isNear) count++;
					isNear=true;
					arr[i][j]=0;
					for(int c=0;c<4;c++) {
						if(arr[i+dx[c]][j+dy[c]]==1) {
							i+=dx[c];
							j+=dy[c];
							arr[i][j]=0;
						}
					}
					continue;
				}
				isNear=false;
				
			}
		}
	}
}
