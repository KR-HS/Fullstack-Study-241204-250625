package PR;
import java.util.*;
public class Main2 {
	static int count=0;
    public static int fib(int n){
        if(n==1 || n==2){
            count++;
            return 1;
        }
        else{
            return(fib(n-1)+fib(n-2));
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fib(N);
        System.out.println(count+" "+(N-2));
        
        

    }
}
