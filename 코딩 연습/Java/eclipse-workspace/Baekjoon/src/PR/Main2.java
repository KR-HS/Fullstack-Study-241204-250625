package PR;
import java.io.*;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			long input = Long.parseLong(br.readLine());
			if(input==0||input==1) {
				bw.write(2+"\n"); 
				continue;
			}
			
			find:while(true) {
				for(int j=2;j<=Math.sqrt(input);j++) {
					if(input%j==0) {
						input++;
						continue find;
					}
				}
				System.out.println(input);
				break;
			}
			bw.write(input+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
