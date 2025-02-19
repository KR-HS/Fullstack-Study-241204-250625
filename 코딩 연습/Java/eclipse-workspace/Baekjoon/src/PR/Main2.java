package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] answer= new int[n];
                
       
        for(int i=0;i<n;i++) {
        	stairs[i]=Integer.parseInt(br.readLine());
        }
        answer[0]=stairs[0];
        if(n==1) {
        	bw.write(answer[n-1]+"\n");
        	bw.flush();
        	return;
        }
        answer[1]=answer[0]+stairs[1];
        if(n==2) {
        	bw.write(answer[n-1]+"\n");
        	bw.flush();
        	return;
        }
        answer[2]=Math.max(stairs[1]+stairs[2], answer[0]+stairs[2]);
        
        
        for(int i=3;i<n;i++) {
        	answer[i]=Math.max(answer[i-2]+stairs[i], answer[i-3]+stairs[i-1]+stairs[i]);
        }
        
        
        bw.write(answer[n-1]+"\n");
        bw.flush();
        br.close();
        bw.close();
	}
}

