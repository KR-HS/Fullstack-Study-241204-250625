package PR;

import java.util.Arrays;
import java.util.Scanner;

public class PR10811{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr = new int[N];
        
        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
        //
        
        for(int j=0;j<M;j++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            int[] arr1 = Arrays.copyOfRange(arr, start-1, end);
            
            for(int k=start-1;k<=end-1;k++){
                arr[k]=arr1[end-k-1];
            }
        }
        for(int ar:arr){
            System.out.print(ar+" ");
        }
        sc.close();
    }
}
