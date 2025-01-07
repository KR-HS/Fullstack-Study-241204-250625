package PR;
import java.util.*;

public class PR10815{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // 카드
        int N=sc.nextInt();
        Set<Integer> card =new HashSet<>();
        for(int i=0;i<N;i++){
            card.add(sc.nextInt());
        }
        
        // 찾을 수
        int M = sc.nextInt();
        for(int j=0;j<M;j++){
        	  System.out.print(card.contains(sc.nextInt())?1+" ":0+" ");
        }
        
        
    }
}