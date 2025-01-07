package day04;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		// 배열의 정렬 - 정렬의 방식은 매우 다양
		// 선택정렬 - 장점 : 쉽다 , 단점 : 느리다
		int[] arr = {5,23,1,43,200,100,40};
		
		// 1,23,5,43,200,100,40 		- 1회전
		// 1, 5, 23, 43, 200, 100, 40   - 2회전
		// 1, 5, 23, 43, 200, 100 ,40	- 3회전
		// 1, 5, 23, 40, 200, 100, 43	- 4회전
		// 1, 5, 23, 40, 43, 100 ,200	- 5회전
		// 1, 5, 23, 40, 43, 100 ,200	- 6회전
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
