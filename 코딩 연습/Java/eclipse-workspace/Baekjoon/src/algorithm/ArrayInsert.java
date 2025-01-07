package algorithm;

import java.util.*;
public class ArrayInsert {

	public static void main(String args[]) {
		
		// 배열 - 크기가 고정
		// 배열에 값을 추가? -> 크기가 + 1인 배열을 새롭게 생성해서, 값을 복사
		
		
		// 60번 학우가 전학을 왔다면?
		int[] arr = {10,20,30,40,50};
		int[] newArr = new int[arr.length+1];
		
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		
		newArr[newArr.length-1]=60;
		System.out.println(Arrays.toString(newArr));
		System.out.println("---------------------");
		
		// 중간에 값을 추가
	}
}
