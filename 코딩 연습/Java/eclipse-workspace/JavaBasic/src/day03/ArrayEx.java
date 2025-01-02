package day03;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		
		//1. 배열의 선언
		int[] arr;
		
		//2. 배열의 생성
		arr = new int[5];
		System.out.println(arr); //배열의 주소값(만들어진 위치)가 나옴
		
		//3. 배열의 초기화
		arr[0] = 34;
		arr[1] = 100;
		arr[2] = 300;
		arr[3] = 54;
		arr[4] = 200; //마지막상자
		//arr[5] = 123; //err
		
		//4. 배열의 사용
		System.out.println("배열의 3번째 값:" + arr[2] );
		System.out.println("배열의 1번째 값:" + arr[0] );
		
		//5. 배열의 저장된 값을 한눈에 문자열로 확인
		System.out.println( Arrays.toString(arr)  );
		
		//6. 배열의 길이를 확인하는 명령어. 배열명.length
		System.out.println( "배열의 길이:" + arr.length );
		
		//7. 배열의 선언과 생성을 동시에 하는 방법
		int[] arr2 = new int[10]; 
		
		//8. 배열의 선언과 생성, 초기화 까지 동시에 하는 방법
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		int[] arr4 = new int[] {1, 2, 3, 4, 5, 6};
		
		//9. 배열의 초기값을 지정하지 않으면, 기본값으로 초기화가 됩니다.
		//0, 0.0, false, null
		System.out.println( Arrays.toString(arr2) );
		
		//크기가 7인 문자열 배열을 만들고, 월~일 저장
		String[] sArr = new String[7];
		sArr[0] = "월";
		sArr[1] = "화";
		sArr[2] = "수";
		sArr[3] = "목";
		sArr[4] = "금";
		sArr[5] = "토";
		sArr[6] = "일";
		
		System.out.println(Arrays.toString(sArr) );
		
		
		
		
	}
}
