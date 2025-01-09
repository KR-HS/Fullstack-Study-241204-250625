package PR;
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int k=sc.nextInt();
        long[] arr=new long[k];
        long n =sc.nextInt();
        long end=0; 
        long start=1;
        long max=1;
        for(int i=0;i<k;i++){
            arr[i]=sc.nextLong();
            if(end<arr[i]) end=arr[i];
        }
        
        while(start<=end){
            long mid=(start+end)/2;
            long sum=0;
            for(long len:arr){
                sum+=(len/mid);
            }    
            if(sum<n){
                end=mid-1;
            }
            else{
                max=mid;
                start=mid+1;
            }
        }            
        System.out.println(max);
    }
}






