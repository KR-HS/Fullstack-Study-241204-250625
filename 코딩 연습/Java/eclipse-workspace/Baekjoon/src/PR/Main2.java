package PR;
import java.util.*;
import java.io.*;
public class Main2 {

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        int[] arr = new int[str.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        
        for(int i=arr.length-1;i>=0;i--){
           System.out.print(arr[i]); 
        }
        System.out.println();
        sc.close();
    }
}
