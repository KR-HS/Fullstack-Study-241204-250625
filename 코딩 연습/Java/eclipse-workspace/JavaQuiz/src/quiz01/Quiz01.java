package quiz01;

public class Quiz01 {
	public static void main(String[] args) {
		// 문제 1 - 다음 연산에 대한 결과를 유추해 보세요.
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		
		
		System.out.println(y += 10 - x++); //13 , y=15,x=3
		System.out.println(x+=2); //5 , x=5
		System.out.println( !('A' <= c && c <='Z') ); //false
		System.out.println('C'-c);  //2
		System.out.println(c+1); // 66
		System.out.println(++c); //B
		System.out.println(c++); //B ,c=C
		System.out.println(c); //C


		System.out.println("-------------------------------------");
		// 문제 2 - 랜덤한 두 주사위의 합을 구하는 문제입니다.
		// 1~6까지 주사위를 2개 만들어서 두 주사위의 합을 구해주세요.
		// "두 주사위의 합은: x" 형식으로 출력해주세요.
		int num1 =((int)(Math.random()*10))%6+1;
		int num2 =((int)(Math.random()*10))%6+1;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println("두 주사위의 합은 : "+(num1+num2));
		
	}
}
