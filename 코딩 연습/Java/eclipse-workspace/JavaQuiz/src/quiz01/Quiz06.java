package quiz01;
import java.util.Scanner;
public class Quiz06 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자입력 : ");
		int num = sc.nextInt();
		System.out.println(num==0?"0":(num<0?"음수":(num%2==0?"짝수":"홀수")));
		sc.close();
	}
}
