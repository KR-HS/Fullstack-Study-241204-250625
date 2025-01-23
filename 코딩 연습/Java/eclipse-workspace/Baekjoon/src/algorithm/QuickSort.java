package algorithm;

public class QuickSort {
	
	public static void quickSort(int[] arr,int start,int end) {
		if(start>=end) {return;}
		
		int pivot = start;
		int left = start+1;
		int right= end;  // 1차 분할이후 pivot의 위치

		while(left<=right) {
			while(left<=end&&arr[left]<=arr[pivot]) {
				left++;
			}
			while(right>start&&arr[right]>=arr[pivot]) {
				right--;
			}
			if(left>right) {
				int temp=arr[pivot];
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
	public static void main(String args[]) {
		// 내용 입력
	}
}
