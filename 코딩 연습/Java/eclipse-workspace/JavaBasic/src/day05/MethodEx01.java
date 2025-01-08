package day05;

public class MethodEx01 {
	public static void main(String[] args) {
		/*
		 * 함수는 만들고, 사용하는 과정(호출)이 있다.
		 * 2. 메서드 안에는 메서드를 선언할 수 없음.
		 */
	}
	
	static int sumNum() {
			int sum=0;
			for(int i=1;i<=10;i++) {
				sum+=i;
				
			}
			return sum;
			
	}
	
	static String randomStr() {
		String str = "";
		for(char c='A';c<='Z';c++){
			str+=c;
		}
		return str;
	}
}
