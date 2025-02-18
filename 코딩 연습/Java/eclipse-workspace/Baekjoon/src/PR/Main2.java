package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        int ct =0;
        while(n!=1) {
        	if(n%3==0) {
        		n/=3;
        		ct++;
        	}
        	else if(n%2==0) {
        		n/=2;
        		ct++;
        	}
        	else {
        		n--;
        		ct++;
        	}
        }
        bw.write(ct+"\n");
        bw.flush();
        br.close();
        bw.close();
	}
}

