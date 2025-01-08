package day04;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String args[]) {
		
		// 복사의 개념 2개
		// 얕은 복사
		// 깊은 복사
		
		int[] arr = {1,2,3,4,5};
		int[] newArr = arr; // 얕은 복사 - 주소값의 복사(원본배열도 같이 바뀜)
		
		System.out.println(Arrays.toString(newArr));
		newArr[0]=100;
		System.out.println("newArr:"+Arrays.toString(newArr));
		System.out.println("arr:"+Arrays.toString(arr));
		
		// 깊은 복사 - 완전히 새로운 배열을 만들고, 요소를 옮겨 담는다.
		
		int[] arr2 = new int[arr.length];
		
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=arr[i];
		}
		// 값을 변경하더라고 원본배열에는 영향을 미치지 않음.
		arr2[0]=200;
		System.out.println("원본: "+Arrays.toString(arr));
		System.out.println("사본: "+Arrays.toString(arr2));
		
	}
}
