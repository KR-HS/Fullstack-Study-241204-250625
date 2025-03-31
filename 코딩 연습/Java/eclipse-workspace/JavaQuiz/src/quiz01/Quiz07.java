package quiz01;
import java.util.Scanner;

public class Quiz07 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1>");
		int a= sc.nextInt();
		
		System.out.print("연산을 선택하세요[+,-,*,/]>");
		String op=sc.next();
		
		System.out.print("정수2>");
		int b = sc.nextInt();
		
		switch(op) {
			case "+":
				System.out.println("결과: "+(a+b));
				break;
			case "-":
				System.out.println("결과: "+(a-b));
				break;
			case "*":
				System.out.println("결과: "+(a*b));
				break;
			case "/":
				System.out.println("결과: "+((double)a/b));
				break;
			default:
				System.out.println("사칙연산 기호를 입력해주세요.\n[+,-,*,/]");
				break;
		}
		sc.close();
	}
}
