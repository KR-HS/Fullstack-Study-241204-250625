package day06;

public class PenMain {
	public static void main(String args[]) {
		// Pen을 쓰고 싶으면 객체로 생성
		// 펜으 속성에 접근 할 때 . 연산자를 씁니다.
		Pen black = new Pen();
		black.ink ="검정";
		black.price=1000;
		black.company="모나미";
		
		black.write();
		String b_info=black.info();
		System.out.println(b_info);
		
		
		Pen red = new Pen();
		red.ink ="빨강";
		red.price=1200;
		red.company="하이테크";
		
		red.write();
		String r_info=red.info();
		System.out.println(r_info);
	}
}
