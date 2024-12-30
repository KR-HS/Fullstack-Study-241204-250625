package day01;

public class SystemOut {
	public static void main(String args[]) {
		// main이라고 ctrl +space를 누르면 자동생성

		
		System.out.println("ABB");
		System.out.println("CDD");
		// 1. 개행을 포함 println() - 맨 마지막에 \n을 자동으로 넣어줌
		System.out.println("안녕하세요");
		System.out.print("금요일입니다.\n");

		//
		// 2. 개행이 없는 print()
		System.out.print("줄바꿈이 없음");

		// 3. 형식 지정 출력문 printf()
		/*
		 * 서식문자
		 * \n - 줄바꿈
		 * \t - 탭버튼 정렬
		 * %d - 정수형 입력받음
		 * %c - 문자형 입력받음
		 * %s - 문자열 입력받음
		 * %f - 실수형 입력받음
		 */
		System.out.printf("%s가 하고싶은 말을 맨 앞에 적습니다.", "홍길동");

		System.out.printf("\n%s가 하고싶은 말을 맨앞에 적습니다. %d시 %d몇분전", "홍길돌", 5, 7);
		System.out.printf("\n원주율은 %f입니다.", 3.14);
		System.out.printf("\n원주율은 %.2f입니다.", 3.14); // 소수점 2자리 까지만 나타냄
		
		System.out.printf("\n%dx%d=%d %dx%d=%d",2,1,2*1,2,2,2*2);
	}
}
