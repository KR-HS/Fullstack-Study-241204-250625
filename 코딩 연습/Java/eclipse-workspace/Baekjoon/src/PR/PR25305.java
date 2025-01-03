package PR;

import java.util.Arrays;
import java.util.Scanner;
public class PR25305 {
	public static void QuickSort(int[] arr,int start,int end){
		if(start>=end) {return;}
        int pivot = start;
        int left = start+1;
        int right = end;
        
        while(left<=right){
            while(left<=end&&arr[left]<=arr[pivot]){
                left++;
            }
            while(right>start&&arr[right]>=arr[pivot]){
                right--;
            }
            if(left>right){
                int temp = arr[pivot];
                arr[pivot]=arr[right];
                arr[right]=temp;
            }
            else{
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        QuickSort(arr,start,right-1);
        QuickSort(arr,right+1,end);
    }
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        
        int[] score = new int[N];
        for(int i=0;i<score.length;i++){
            score[i]=sc.nextInt();
        }
        
        QuickSort(score,0,N-1);
        
        System.out.println(score[N-k]);
    }
}
