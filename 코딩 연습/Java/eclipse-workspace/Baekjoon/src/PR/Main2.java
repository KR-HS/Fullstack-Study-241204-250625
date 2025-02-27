package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
        	int input = Integer.parseInt(br.readLine());
        	bw.write(input*input+"\n");
        	return;
        }
        
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        bw.write(arr[0]*arr[n-1]+"\n");
        bw.flush();
        bw.close();
        br.close();
	}
}

