package PR;
import java.util.*;
import java.io.*;
public class PR7785 {
	public static void main(String args[]) throws NumberFormatException,IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		// TreeSet은 자동정렬, HashSet은 자동정렬 기능 지원 x 
		Set<String> inout = new TreeSet<>();
		
		for(int i=0;i<n;i++) {
			String[] record = br.readLine().split(" ");
			if(record[1].equals("enter")) {
				inout.add(record[0]);
			}
			else {
					inout.remove(record[0]);
			}
		}
		
		ArrayList<String> list = new ArrayList<>(inout);
		for(int i=list.size()-1;i>=0;i--) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
