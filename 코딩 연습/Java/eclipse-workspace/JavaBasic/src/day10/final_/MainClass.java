package day10.final_;

public class MainClass {
	public static void main(String[] args) {
		
		Person kim = new Person("김길동","123123-123123");
		Person hong = new Person("홍길동","234234-234234");
		
		System.out.println(kim.ssn);
		System.out.println(hong.ssn);
		
		// 값의 변경 금지
		// kim.ssn="바꿔야지";
		
		System.out.println("-".repeat(30));
		
		System.out.println(Constant.PI);
		System.out.println(Constant.O2);
		System.out.println(Constant.EARTH_RADIUS);
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
	}
}
