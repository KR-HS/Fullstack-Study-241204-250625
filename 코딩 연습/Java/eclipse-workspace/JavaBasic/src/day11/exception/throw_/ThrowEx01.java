package day11.exception.throw_;

public class ThrowEx01 {
	public static void main(String[] args) {
		/*
		 * 
		 * 예외 발생시키기 throw
		 * 
		 * 메서드, 생성자 실행도중에 throw키워들 만나면, 예외가 생성
		 * 
		 */
		try {
		System.out.println(calc(10));
		System.out.println(calc(-10)); // 잘못된 값
		}catch(Exception e) {
//			System.out.println("양수 값을 전달하세요.");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static int calc(int n) throws Exception {
		
		if(n<0) {
			// throw로 예외를 생성하면, try~catch 또는 throws구문으로 예외 처리
			throw new Exception("양수 값을 전달하세요."); // 강제 예외 생성
		}
		int sum=0;
		for(int i=1;i<=n;i++) sum+=i;
		return sum;
	}
}
