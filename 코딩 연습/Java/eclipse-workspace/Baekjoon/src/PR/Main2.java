package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);	
        int m = Integer.parseInt(str[1]);	
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];
        String[] str1 =br.readLine().split(" ");
        for(int i=1;i<n+1;i++) {
        	arr[i]=Integer.parseInt(str1[i-1]);
        	dp[i]=dp[i-1]+arr[i];
        }

        System.out.println(Arrays.toString(dp));
		while(m>0) {
			m--;
			String[] str2 = br.readLine().split(" ");
			int start=Integer.parseInt(str2[0]);
			int end=Integer.parseInt(str2[1]);
			
			bw.write(dp[end]-dp[start-1]+"\n");
		}
        
        bw.flush();
        bw.close();
        br.close();
	}
}

