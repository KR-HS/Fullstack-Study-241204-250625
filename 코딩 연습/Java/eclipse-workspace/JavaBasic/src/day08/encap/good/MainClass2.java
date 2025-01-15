package day08.encap.good;

import java.util.Arrays;

public class MainClass2 {
	public static void main(String args[]) {
		// 객체를 담는 배열
		Member[] arr = new Member[2];
		
		Member m1 = new Member("홍길동",20,"서울","010",true);
		Member m2 = new Member("이순신",30,"경기","010",false);
		
		arr[0]=m1;
		arr[1]=m2;
		
		System.out.println(Arrays.toString(arr));
		System.out.println("-".repeat(30));
		
		for(int i=0;i<arr.length;i++) {
			
		}
		String a="";

	}
}
