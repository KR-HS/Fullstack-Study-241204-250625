package day04;
import java.util.*;
public class BreakEx02 {
	public static void main(String args[]) {
		
		// 정답맞추기
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("3 X 4 = ?");
			System.out.print("정답 > ");
			
			int answer= sc.nextInt();
			
			if(answer==3*4) {
				System.out.println("정답입니다.");
				break;
			}
			else {
				System.out.println("오답입니다. 다시 입력해주세요.");
			}
		}
	}
}
