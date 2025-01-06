package PR;
import java.util.*;
import java.io.*;
public class PR10989{
    public static void main(String args[]) throws NumberFormatException,IOException{
    	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int N = Integer.parseInt(bf.readLine());
         
         int[] arr=new int[10001];
         for(int i=0;i<N;i++){
             arr[Integer.parseInt(bf.readLine())]++;
         }
         
         for(int i =0;i<arr.length;i++) {
        	 for(int j =0;j<arr[i];j++) {
        		bw.write(i+"\n");
        	 }
         }
         bw.flush();
         bf.close();
         bw.close();
    }
}