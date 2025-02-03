package generic.good;

public class MainClass {

	public static void main(String[] args) {
		
		Person<String> p = new Person<String>();
		p.setT("홍길동");
		String name = p.getT();
		
		Person<ABC> abc = new Person<>(); //뒤에 <> 타입생략 가능
		abc.setT( new ABC() );
		ABC a = abc.getT();
		
		//<>를 안주면 마법의 상자처럼 동작
		//Person p2 = new Person();
		
		//제네릭에는 기본타입이 저장될 수 없습니다.
		Person<Integer> p3 = new Person<>();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
