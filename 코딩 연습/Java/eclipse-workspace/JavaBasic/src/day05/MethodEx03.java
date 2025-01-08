package day05;

public class MethodEx03 {
	public static void main(String args[]) {
		/*
		 * 반환유형(return type)
		 * 1. 반환유형은 메서드가 실행결과를 돌려주는 값에 대한 type
		 * 
		 * 2. 반환유형이 있으면 return 뒤에 값을 담아주고,
		 *    반환유형이 없으면 반환 유형자리에 voidw라고 적으면 됨.
		 * 
		 * 3. 리턴이 있는 함수들은 호출구문이 값이 되기 때문에, 
		 *    출력 구문이나 다른 함수의 매개변수로 쓸수 있음.
		 */
		
		int result=add(1,add(1,1));
		
		System.out.println("결과 : " + result);
		sub(1,2);
		
		// void형 메서드에서도 return 키워드를 쓸 수 있음
		noReturn("hello");
		noReturn("bye");
		
	}
	
	//a+b를 리턴하는 함수
	static int add(int a,int b) {
//		int result=a+b;
//		return result;
		return a+b;
	}
	
	// 반환이 없는 함수(메서드)
	static void sub(int a, int b) {
		System.out.println(a+" - "+b+" = "+(a-b));
	}
	
	// bye 매개변수가 들어오면, 기능하지 않는 함수.
	static void noReturn(String s) {
		if(s.equals("bye")) return;
		System.out.println("매개변수는 : "+s+"입니다.");
	}
}
