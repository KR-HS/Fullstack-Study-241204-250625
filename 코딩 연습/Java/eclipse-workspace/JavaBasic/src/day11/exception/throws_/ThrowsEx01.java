package day11.exception.throws_;

public class ThrowsEx01 {
	public static void main(String[] args) {
		/*
		 * 메서드, 생성자에서 발생되는 예외를 떠넘기는 키워드 throws
		 * throws구문이 붙어 있는 메서드, 생성자를 호출할 때는 예외처리를 대신 진행
		 * 즉, 예외처리를 강요할 때 사용할 수 있음.
		 */
		try {
		greeting(10);
		}catch(Exception e) {
			System.out.println("인덱스는 0~2까지 전달하세요");
		}
		try{
			Class.forName("wefsdv");
		}catch(ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace(); // 개발 도중, 에러의 내용을 보기 위해서 자주 사용
		}
		System.out.println("프로그램 정상종료");
	}
	
	private static String[] arr = {"hello","안녕하세요","사요나라"};
	
	public static void greeting(int index) throws Exception{
		// 메서드를 만드는 사람이 예외가 날 수 있음을 알려주는 throws 키워드
		System.out.println(arr[index]);
	}
}
