
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        
        int maxNum=Math.max(a,Math.max(b,c));

        int low_sum=a+b+c-maxNum;

        if(low_sum>maxNum){
            System.out.println(low_sum+maxNum);
        }
        else if(low_sum==maxNum){
            System.out.println(low_sum+maxNum-1);
        }
        else{
            System.out.println(low_sum+low_sum-1);
        }
        
        

    }
}
