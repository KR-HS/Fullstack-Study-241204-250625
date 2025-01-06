package PR;
import java.io.*;

public class PR1025 {
	public static void main(String args[]) throws NumberFormatException,IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		boolean n_sqrt=false;
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		String[][] arr= new String[N][M];
		int max=0;

		for(int i=0;i<N;i++) {
			arr[i]=br.readLine().split("");
		}
		
		String number="";
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int x=-N;x<N;x++) {
					for(int y=-M;y<M;y++) {
						number="";
						int dx=i;
						int dy =j;
						if(x==0&&y==0) continue;
						while((0<=dx&&dx<N) && (0 <=dy&&dy<M)) {
							number+=arr[dx][dy];
							if(Math.sqrt(Integer.parseInt(number))==(int)Math.sqrt(Integer.parseInt(number))) {
								max=Math.max(max, Integer.parseInt(number));
								n_sqrt=true;
							}
							dx+=x;
							dy+=y;
						}
					}
				}
			}
		}
		if(!n_sqrt) bw.write(-1+"\n");
		else bw.write(max+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
