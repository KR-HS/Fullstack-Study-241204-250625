package day04;

import java.util.Arrays;

public class ArrayMatrix {
	public static void main(String args[]) {
		
		// 행렬 - 2차원 배열
		// 배열안에 배열이 저장되는 형태
		//int[][]

		int[] kor= {10,20,30};
		int[] math = {40,50,60};
		int[] eng = {70,80,90};
		
		int[][] arr= {kor,math,eng};
		
		System.out.println(Arrays.toString(arr));
		
		
		
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[1]);
		
		// 2차원 배열의 사용
		System.out.println(arr[0][0]); // 행, 열
		System.out.println(arr[0][1]);
		
		// 2차원 배열을 한번에 생성하고 초기화
		int[][] arr2= {
				{10,20,30},{40,50,60},{70,80,90}
		};
		
		// 2차원 배열의 값을 한눈에 보는 방법
		System.out.println(Arrays.deepToString(arr2));
		
		
	
		// 2차원 배열의 크기만 지정하는 방법
		int[][] arr3 = new int[3][4];
		System.out.println(Arrays.deepToString(arr3));
		int x =1;
		// 2차원 배열의 순회
		for(int i=0;i<arr3.length;i++) {
			for(int j=0;j<arr3[0].length;j++) {
				arr3[i][j]=x++;
				System.out.println(i+"행 "+j+"열");
			}
		}
		System.out.println(Arrays.deepToString(arr3));
		
	}
}
