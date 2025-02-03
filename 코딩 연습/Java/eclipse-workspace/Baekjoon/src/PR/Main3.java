package PR;
import java.util.*;
public class Main3 {
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
	        int n = Integer.parseInt(sc.nextLine());
	        String[] str = new String[n];
	        for(int i=0;i<n;i++){
	            str[i]=sc.nextLine();
	        }
	        Arrays.sort(str,(s1,s2)->{
	            if(s1.length()==s2.length()){
	                return s1.compareTo(s2);
	            }
	           return Integer.compare(s1.length(),s2.length()); 
	        });
	        
	        
	        for(String s: str){
	            System.out.println(s);
	        }
	     sc.close();
	}
}
