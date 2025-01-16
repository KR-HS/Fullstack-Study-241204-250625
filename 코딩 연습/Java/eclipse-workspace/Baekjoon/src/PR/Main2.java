package PR;
import java.util.*;
public class Main2 {
	 public static void main(String args[]){
	        Scanner sc = new Scanner(System.in);

	        
	        String[] in = {"CU",":-)",":-(",";-)",":-P","(~.~)","TA","CCC","CUZ","TY","YW","TTYL"};
	        String[] out = {"see you","I’m happy","I’m unhappy","wink","stick out my tongue","sleepy","totally awesome",
	                       "Canadian Computing Competition","because","thank-you","you're welcome","talk to you later"};
	        outerloop: for(;;){
	            String input = sc.nextLine();
	            for(int i=0;i<in.length;i++){
	                if(input.equals(in[in.length-1])){
	                    System.out.println(out[out.length-1]);
	                    return;
	                }
	                if(in[i].equals(input)){
	                    System.out.println(out[i]);
	                    continue outerloop;
	                }
	            }
	            System.out.println(input);
	            

	        }
	    }
}
