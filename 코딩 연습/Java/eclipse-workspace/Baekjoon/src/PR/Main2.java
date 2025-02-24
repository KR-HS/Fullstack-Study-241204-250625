package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        int[] ct = new int[11];
        
        ct[1]=1;
        ct[2]=2;
        ct[3]=4;
        
        for(int i=4;i<ct.length;i++) {
        	ct[i]=ct[i-1]+ct[i-2]+ct[i-3];
        }
        
        for(int i=0;i<n;i++) {
        	int input = Integer.parseInt(br.readLine());
        	bw.write(ct[input]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
	}
}

