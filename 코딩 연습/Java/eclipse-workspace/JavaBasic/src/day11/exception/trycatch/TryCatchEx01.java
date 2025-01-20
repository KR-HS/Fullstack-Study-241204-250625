package day11.exception.trycatch;

public class TryCatchEx01 {
	public static void main(String[] args) {
		int i=10;
		int j=0;
		System.out.println(i+j);
		System.out.println(i-j);
		try {
		System.out.println(i/j);
		}catch(Exception e) {
			// catch () 안에는 예외의 종류가 들어감
			// Exception은 모든 예외 처리 가능
			System.out.println("예외발생");
			
		}
		System.out.println(i*j);
	}
}
