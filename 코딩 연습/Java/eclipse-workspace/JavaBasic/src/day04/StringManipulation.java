package day04;

import java.util.Arrays;

public class StringManipulation {
	public static void main(String args[]) {
//		char[] arr = {'a','b','c'};
//		String str = new String(arr);
//		System.out.println(str);
		
		String str="abc";
		
		// 문자열을 다룰 수 있는 여러가지 함수를 제공해줍니다.
		// str에 . 찍어서 사용
		char c= str.charAt(0);
		System.out.println(c);
		int len=str.length();
		System.out.println("문자열의 길이 : "+len);
		
		str="안녕하세요? 문자열은 문자의 합 입니다.";
		int index=str.indexOf("문자의 합");
		System.out.println("'문자의 합'이 발견된 위치: "+index);
		
		int b = str.indexOf("DSFGETRED%#");
		System.out.println("찾을 문자가 없으면 : "+b); // 찾을 문자가 없으면 -1 반환
		
		// 문자열 변경하기 - replace(타겟문자열, 바꿀문자열)
		String str1=str.replace("문자","word");
		System.out.println(str); // 원본문자는 그대로
		System.out.println(str1); // 발견되는 모든 문자열을 바꿈.
		// 모든 공백 제거
		str = str.replace(" ","");
		System.out.println(str);
		
		System.out.println("--------------------------");
		
		//대소문자 변경
		str = "Hello World!";
		
		String r2 = str.toUpperCase(); //대문자로
		String r3 = str.toLowerCase(); //소문자로

		System.out.println(r2);
		System.out.println(r3);
		
		
		// 앞뒤 공백제거 trim()
		str ="     010-1234- 5678     ";
		System.out.println(str);
		String r4 = str.trim();
		System.out.println(r4);
		
		// 문자열 자르기
		// substring
		// split
		// toCharArray
		
		str="010-1234-5678";
		String r5= str.substring(3);
		System.out.println(r5);
		
		String r6= str.substring(3,6);
		System.out.println(r6);
		
		String[] arr = str.split("-");
		System.out.println(Arrays.toString(arr));
		
		char[] arr2 = str.toCharArray(); // 한글자씩 잘라서 char[] 반환
		System.out.println(Arrays.toString(arr2));
		
		// 합치기
		// join()
		String r7= String.join("!!", "링딩동","링딩동","링딩동","링딩동");
		System.out.println(r7);
		
		String[] str_arr={"링딩동","링딩동","링딩동","링딩동"};
		String r8= String.join("!!", str_arr);
		System.out.println(r8);
		
		// "서울 > 대전 > 대구 > 부산 > 찍고";
		String[] arr3={"서울","대전","대구","부산","찍고"};
		String sep=" > ";
		for(int i=0;i<arr3.length;i++) {
			if(i==arr3.length-1) {
				System.out.println(arr3[i]);
				break;
			}
			System.out.print(arr3[i]+sep);
		}
		System.out.println(String.join(" > ",arr3));
	}
}
