package PR;
import java.util.Scanner;
public class PR2587 {
	public static void quickSort(int[] arr, int start, int end) {
		if(start>=end) {return;}
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left<=right) {
			while(left<=end&&arr[left]<=arr[pivot]) {
				left++;
			}
			while(right>start&&arr[right]>=arr[pivot]) {
				right--;
			}
			if(left>right) {
				int temp = arr[pivot];
				arr[pivot]=arr[right];
				arr[right]=temp;
			}
			else {
				int temp = arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
			}
		}
		
		quickSort(arr,start,right-1);
		quickSort(arr,right+1,end);
		
	}
	public static int findMean(int[] arr) {
		int sum=0;
		for(int ar:arr) {
			sum+=ar;
		}
		return sum/arr.length;
	}
	public static int findMedian(int[] arr) {
		quickSort(arr,0,arr.length-1);
		
		return arr[Math.round(arr.length/2)];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(findMean(arr));
		System.out.println(findMedian(arr));
	}
}
