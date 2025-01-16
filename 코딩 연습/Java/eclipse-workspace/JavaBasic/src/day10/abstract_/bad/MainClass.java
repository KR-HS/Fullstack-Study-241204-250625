package day10.abstract_.bad;

public class MainClass {
	public static void main(String[] args) {
		SeoulStore s =new SeoulStore();
		s.apple();
		s.grape(); // 오버라이드가 되지 않으면, 잘못된 메서드 실행이 될 수 있음.
		s.melon();
		s.orange();
	}
}
