package day04;

public class BreakEx01 {
	public static void main(String args[]) {
		for(int i=1;i<=10;i++) {
			if(i==5) break;  // 실행시킬 구문이 1개면 {} 생략가능
		
			System.out.println(i);
		}
		System.out.println("--------------");
		int i=1;
		while(true) {
			
			System.out.println(i);
			if(i==15) {
				break;
			}
			i++;
		}
	}
}
