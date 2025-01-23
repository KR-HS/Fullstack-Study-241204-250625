package PR;
import java.util.*;
public class Main3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().replace(" ", "");
		if(input.length()==0) return;
        String[] word=input.toUpperCase().split("");
        Map<String,Integer> map = new HashMap<>();
        
        for(String s: word){
            if(map.containsKey(s)) {
            	map.put(s,map.get(s)+1);
            }
            else {
            	map.put(s,1);
            }
        }
        String max_key="";
        boolean isFirst=true;
        boolean duple=false;
        for(String key:map.keySet()){
            if(isFirst) {
            	isFirst=!isFirst;
            	max_key=key;
            	continue;
            }
        	if(map.get(max_key)==map.get(key)){
                duple=true;
                continue;
            }
            if(map.get(max_key)<map.get(key)){
                max_key=key;
                duple=false;
             }
        }
        if(duple)System.out.println("?");
        else System.out.println(max_key);
		
	}
}
