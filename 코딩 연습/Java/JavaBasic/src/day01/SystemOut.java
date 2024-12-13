package day01;

public class SystemOut {
	public static void name() {
		// main이라고 ctrl +space를 누르면 자동생성

		
		// 개행을 포함 println() - 맨 마지막에 \n을 자동으로 넣어줌
		System.out.println("안녕하세요");
		System.out.println("금요일입니다.");

		//
		// 개행이 없는 print()
		System.out.println("줄바꿈이 없음");

		// 형식적인 출력문 printf()
		/*
		 * \n 줄바꿈 \t tab 버트마늠 6시간 띄어쓰기 %d 문자열 입력밭음 %s 문자열 입력받음 %f 실수형 입력받음
		 */
		System.out.printf("%s가 하고싶은 말을 맨 앞에 적습니다.", "홍길동");

		System.out.printf("%s가 하고싶은 말을 맨앞에 적습니다. %d시 %d몇분전", "홍길돌", 5, 7);
		System.out.printf("%d + %d = %d", 3, 5, 8);
	}
}
