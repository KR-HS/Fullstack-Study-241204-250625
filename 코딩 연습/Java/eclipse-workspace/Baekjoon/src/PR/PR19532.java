package PR;
import java.io.*;

public class PR19532 {
	public static void main(String args[]) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] ar = br.readLine().split(" ");
		
		int a = Integer.parseInt(ar[0]);
		int b = Integer.parseInt(ar[1]);
		int c = Integer.parseInt(ar[2]);
		int d = Integer.parseInt(ar[3]);
		int e = Integer.parseInt(ar[4]);
		int f = Integer.parseInt(ar[5]);
		
		outer:for(int x=-999;x<=999;x++) {
			
			for(int y=-999;y<=999;y++) {
				
				if(a*x+b*y==c && d*x+e*y==f) {
					bw.write(x+ " "+y+"\n");
					break outer;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();

		
	}
}
