package PR;
import java.util.*;
import java.io.*;
public class Main2 {
	  static int count=0;
	    public static int isPalindrome(String s,int l,int r){
	        count++;
	        if(l>=r) return 1;
	        else if(s.charAt(l)!=s.charAt(r)) return 0;
	        else return isPalindrome(s,l+1,r-1);
	    }
	    
	    public static void main(String args[]) throws IOException,NumberFormatException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n=Integer.parseInt(br.readLine());
	        for(int i=0;i<n;i++){
	            count=0;
	            String s = br.readLine();
	            System.out.println(isPalindrome(s,0,s.length()-1)+" "+count);
	        }
	    }
}
