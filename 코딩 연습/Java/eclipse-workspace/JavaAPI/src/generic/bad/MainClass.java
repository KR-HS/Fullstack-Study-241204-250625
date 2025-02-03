package generic.bad;

public class MainClass {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		p.setObj("홍길동"); //저장
		String name = (String)p.getObj();
		
		p.setObj( new ABC() ); //저장
		ABC abc = (ABC)p.getObj();
		
		/*
		 * Object형으로 선언하면, 무엇이든 저장할 수 있는 장점이 있지만
		 * 반대로 값을 사용할 때, 타입별로 형변환을 해야하는 문제가 발생.
		 * 
		 * 잘못 형변환하면 예외를 발생시킵니다.
		 */
		
		
		
		
		
		
		
		
	}
}
