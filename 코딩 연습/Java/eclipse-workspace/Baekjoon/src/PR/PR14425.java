package PR;
import java.util.*;
import java.io.*;
public class PR14425 {
	// https://www.acmicpc.net/problem/14425
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm= br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		Set<String> arr = new HashSet<>();
		int count=0;
		
		for(int i=0;i<N;i++) {
			arr.add(br.readLine());
		}
		
		for(int j=0;j<M;j++) {
			if(arr.contains(br.readLine()))count++;
		}
		
		bw.write(count+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
