package PR;
import java.util.*;

public class Main2 {

	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        Set<Integer> set = new TreeSet<>();
        
        int N = sc.nextInt();
        int k = sc.nextInt();
        
        for(int i=1;i<=Math.sqrt(N);i++){
            if(N%i==0){
                set.add(i);
                set.add(N/i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        System.out.println(list.get(k-1));
    }
}
