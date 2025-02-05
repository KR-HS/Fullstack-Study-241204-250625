package PR;
import java.util.*;
import java.io.*;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			if(a>b) {
				if(a%b==0) {
					bw.write(a+"\n");
					continue;
				}
			}else if(a<b) {
				if(b%a==0) {
					bw.write(b+"\n");
					continue;
				}
			}else {
				bw.write(a+"\n");
				continue;
			}
			
			Set<Integer> set = new HashSet<>();
			int j=2;
			while(j<=Math.sqrt(a)) {
				if(a%j==0) {
					if(set.contains(j)) {
						a/=j;
						continue;
					}
					set.add(j);
					a/=j;
					continue;
				}
				j++;
			}

			int k=2;
			while(k<=Math.sqrt(b)) {
				if(b%k==0) {
					if(set.contains(k)) {
						b/=k;
						continue;
					}
					set.add(k);
					b/=k;
					continue;
				}
				k++;
			}
			if(set.size()==0) {
				bw.write((long)a*b+"\n");
				continue;
			}else {
				set.add(a);
				set.add(b);
			}
			System.out.println(set.toString());
			
			
			long answer=1;
			for(long num:set) {
				answer*=num;
			}
			bw.write(answer+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
