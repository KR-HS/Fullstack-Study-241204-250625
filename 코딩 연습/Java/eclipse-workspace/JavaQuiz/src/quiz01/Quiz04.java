package quiz01;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		
		//키가 140이상 이고, 나이가 8세 이상이면, 놀이기구 탑승가능
		//아니라면 탑승불가능
		Scanner scan = new Scanner(System.in);
		
		System.out.println("키(double)와 나이(int)를 입력하세요");
		System.out.print("키>");
		double cm = scan.nextDouble();
		System.out.print("나이>");
		int age = scan.nextInt();
		
		if(cm >= 140 && age >= 8) {
			System.out.println("놀이기구 탑승가능");
		} else {
			System.out.println("놀이기구 탑승불가능");
		}

		scan.close();
		
		
		
		
	}
}
