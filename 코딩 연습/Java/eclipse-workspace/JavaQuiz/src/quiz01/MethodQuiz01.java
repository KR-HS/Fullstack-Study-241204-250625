package quiz01;

import java.util.Arrays;

public class MethodQuiz01 {
	static void method1() {
		System.out.println("안녕");
	}
	static String method2(String str) {
		return str;
	}
	static double method3(int a, int b, double c) {
		return a+b+c;
	}
	static String method4(int num) {
		return num%2==0?"짝수":"홀수";
	}
	static void method5(String str,int num) {
		for(int i=0;i<num;i++) {
			System.out.println(str);			
		}
	}
	
	static double maxNum(double a, double b) {
		//return Math.max(a, b);
		return a>=b?a:b;
	}
	
	static int abs(int a) {
		//return Math.abs(a);
		return a>=0?a:-a;
	}
	static String method6(char[] ch) {
		String str="";
		for(char c:ch) {
			str+=c;
		}
		return str;
	}
	
	static int method7(int[] arr) {
		int sum=0;
		for(int ar:arr) {
			sum+=ar;
		}
		return sum;
	}
	
	static String[] method8(String str1,String str2) {
		String[] str = new String[2];
		str[0]=str1;
		str[1]=str2;
		return str;
	}
	public static void main(String args[]) {
		// 메서드1
		method1();
		System.out.println("------------------");
		
		// 메서드2
		System.out.println(method2("메서드2번"));
		System.out.println("------------------");
		
		// 메서드3
		System.out.println(method3(10,20,30.5));
		System.out.println("------------------");
		
		// 메서드4
		System.out.println(method4(5));
		System.out.println("------------------");
		
		// 메서드5
		method5("메서드5",5);
		System.out.println("------------------");
		
		// maxNum메서드
		System.out.println(maxNum(10.5,30.5));
		System.out.println("------------------");
		
		// abs메서드
		System.out.println(abs(-100));
		System.out.println("------------------");
		
		// method6

		System.out.println(method6(new char[] {'m','e','t','h','o','d','6'}));
		System.out.println("------------------");
		
		// method7
		System.out.println(method7(new int[] {10,20,30,40,50}));
		System.out.println("------------------");
		
		// method8
		System.out.println(Arrays.toString(method8("method8","번")));
		System.out.println("------------------");
		
	}
}
