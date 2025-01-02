package day03;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		//1. 스캐너 생성
		Scanner scan = new Scanner(System.in);
		
		//2. 스캐너가 가지고 있는 입력기능을 통해서 데이터를 입력받음.
		//nextDouble() - 실수를 입력받음
		//nextLine() - 공백을 포함한 문자열 받음
		
		System.out.print("이름> ");
		String name = scan.next(); //문자열 받음
		
		System.out.print("나이> ");
		int age = scan.nextInt(); //정수를 받음
		
		
		System.out.println("이름:" + name +", 나이:" + age );		
				
		//3. 스캐너의 자원 반납
		scan.close(); //이 이후에는 스캐너를 다시 사용할 수 x
		
		
		
		
	}
}
