package PR;
import java.util.*;
public class PR2751{
  
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        
        for(int ar:list){
            System.out.println(ar);
        }
    }
}