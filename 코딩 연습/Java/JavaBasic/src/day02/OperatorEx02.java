package day02;

public class OperatorEx02 {
	public static void main(String[] args) {

		// 이항 연산자
		int i = 7 / 3;
		int j = 7 % 3;
		int k = 7 * 3;

		System.out.println("7/3 = " + i);
		System.out.println("7%3 = " + j);
		System.out.println("7*3 = " + k);
		
		// 비교 연산자
		System.out.println(i==j);
		System.out.println(i!=j);
		System.out.println(i>=j);
		System.out.println(i<j);
		System.out.println(k%2==0);
		System.out.println(k%2!=0);
		
		System.out.println("---------------------------------");
		
		// 비트 연산자 &,|,^
		int a =5;
		int b=3;
		
		System.out.println(a&b); // 두 비트가 1이면 1, 다르면 0
		System.out.println(a|b); // 두 비트중 하나만 1이어도 1나환, 둘다 0이면 0
		System.out.println(a^b); // 두 비트가 다르면 0, 같으면 0
		
		int h =100;
		System.out.println(h>>2);
	}
}
