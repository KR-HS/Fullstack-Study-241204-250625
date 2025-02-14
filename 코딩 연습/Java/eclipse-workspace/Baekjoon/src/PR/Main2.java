package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
        int n= Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int cut=(int)Math.round(arr.length*0.15);
        long sum=0;
        
        int count = n-cut*2;
        for(int i=cut;i<n-cut;i++) {
        	sum+=arr[i];
        }
        
        
        bw.write((int)Math.round(sum/(count*1.0))+"\n");
		bw.flush();
		bw.close();
		br.close();	
	}
}


