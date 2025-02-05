package PR;
import java.util.*;
import java.io.*;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str1 = br.readLine().split(" ");
		int c1 = Integer.parseInt(str1[0]);
		int m1 = Integer.parseInt(str1[1]);
		String[] str2 = br.readLine().split(" ");
		int c2 = Integer.parseInt(str2[0]);
		int m2 = Integer.parseInt(str2[1]);
		long c0=c1*m2+c2*m1;
		long c=c1*m2+c2*m1;
		long m=m1*m2;
		long m0=m1*m2;
		if(c==m) {
			bw.write(1+" "+1+"\n");
		}else{

			long remain=0;
			int com=1;

			if(c>m) {
				remain=c%m;
				if(remain==0) {
					bw.write(c/m+" "+1+"\n");
				}
				else {
					int j=2;
					while(j<=Math.sqrt(remain)||remain>=j) {
						if(remain%j==0&&m%j==0) {
							com*=j;
							m/=j;
							remain/=j;
							continue;
						}
						j++;
					}
					bw.write(c0/com+" "+m0/com+"\n");
				}

			}else if(c<m) {
				remain=m%c;
				if(remain==0) {
					bw.write(1+" "+m/c+"\n");
				}
				else {
					int j=2;
					while(j<=Math.sqrt(remain)||remain>=j) {
						if(remain%j==0&&c%j==0) {
							com*=j;
							c/=j;
							remain/=j;
							continue;
						}
						j++;
					}
					
					bw.write(c0/com+" "+m0/com+"\n");
				}
			}
			
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
