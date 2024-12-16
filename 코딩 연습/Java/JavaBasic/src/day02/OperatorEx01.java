package day02;

public class OperatorEx01 {
	public static void main(String args[]) {
		int i=3;
		int j=+3;
		int k=-i;
		
		// 증감 연산자
		int x = 1;
		int y= x++; // 후위 연산자 : 먼저 값을 대입한 후, 자신을 증가.
		System.out.println("x값:"+x);
		System.out.println("y값:"+y);
		
		int n=1;
		int m = ++n; // 전위 연산자 : 먼저 자신을 증가시키고 대입
		System.out.println("n값 :"+n);
		System.out.println("m값 :"+m);
		
		x= 1;
		x++;
		++x;
		System.out.println(x); //3
		System.out.println("----------------------------------------");
		
		// 비트 연산자 ~ : 비트값을 반대로 바꿈 
		byte b= 10; // 0000 1010
		System.out.println(~b); //-11 > 1111 0101
		System.out.println(~b+1);// -10
		
		// 논리 반전 연산자 !
		boolean bool= true;
		System.out.println(!bool);
		System.out.println(!false);
	}	
}
