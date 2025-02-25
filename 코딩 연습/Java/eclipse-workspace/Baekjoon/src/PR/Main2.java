package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
        	int m = Integer.parseInt(br.readLine());
        	Map<String,List<String>> map = new HashMap<>();
        	for(int j=0;j<m;j++) {
        		String[] str = br.readLine().split(" ");
        		
        	}
        }
        bw.flush();
        bw.close();
        br.close();
	}
}

