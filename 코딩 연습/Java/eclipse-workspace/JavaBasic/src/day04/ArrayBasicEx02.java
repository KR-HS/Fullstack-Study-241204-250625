package day04;

import java.util.Arrays;

public class ArrayBasicEx02 {
	public static void main(String args[]) {
		// 크기가 100인 배열에 1~100
		
		int[] arr = new int[100];
		
		for(int i=1;i<=100;i++) {
			arr[i-1]=i;
		}
		System.out.println(Arrays.toString(arr));
		
		
	}
}
