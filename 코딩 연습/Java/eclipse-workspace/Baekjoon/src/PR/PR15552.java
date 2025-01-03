package PR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PR15552 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
		while(T>0) {
			String[] td = br.readLine().split(" ");
			int a = Integer.parseInt(td[0]);
			int b =Integer.parseInt(td[1]);
			bw.write((a+b)+"\n");
			T--;
		}
        bw.flush();
        bw.close();
	}
}