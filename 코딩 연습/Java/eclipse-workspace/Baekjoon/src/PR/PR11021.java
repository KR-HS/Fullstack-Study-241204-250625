package PR;

import java.io.*;
public class PR11021 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] arr = br.readLine().split(" ");
			bw.write("Case #"+(i+1)+": "+(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]))+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
