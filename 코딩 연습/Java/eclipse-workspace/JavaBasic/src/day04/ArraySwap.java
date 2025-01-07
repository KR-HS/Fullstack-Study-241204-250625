package day04;

import java.util.*;
public class ArraySwap {
	public static void main(String args[]) {
		
//		int x= 5;
//		int y = 10;
//		int temp=0;
//		
//		temp = x;
//		x= y;
//		y=temp;
		
		
		// 두 수를 입력받아서, 두 수(인덱스)의 자리 바꾸기
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int temp =0;
		temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		
		System.out.println(Arrays.toString(arr));
		
		sc.close();
	}
}
