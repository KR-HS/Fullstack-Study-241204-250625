package day11.exception.trycatch;

public class TryCatchEx02 {
	public static void main(String[] args) {
		
		String[] greeting= {"hello","안녕하세요","사요나라"};
		int i=0;
		while(i<4) { // 3번쨰 인덱스 err
			try {
			System.out.println(greeting[i]);
			}catch(Exception e) {
				System.out.println("배열의 참조범위를 벗어났습니다.");
			}finally {
				System.out.println("이 문장은 예외와 상관없이 무조건 실행");
			}
			
			i++;
		}
		
		System.out.println("프로그램 정상 종료");
	}
}
