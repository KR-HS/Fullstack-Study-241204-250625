package api.lang.object;

public class MainClass {

	public static void main(String[] args) {
		
		/* 오브젝트 클래스
		 * toString - 객체의 주소를 문자열로 반환
		 * equals - 객체의 주소값을 비교해서, 같은 객체라면 true
		 * hashCode - 객체의값을 고유한 숫자로 반환
		 * getClass - 현재 실행되는 클래스를 반환.
		 * clone (protected) - 객체 복사 
		 * finalize - 객체가 소멸될 때 동작합니다. (정확한 시점을 알기가 어렵다)
		 */
		Person p = new Person("홍길동");
		
		String s = p.toString();
		System.out.println(s);
		
		
		Person p2 = new Person("홍길동");
		boolean r = p.equals(p2);
		System.out.println("이름이 같음?:" + r);
		
		System.out.println("객체의 고유한 숫자값:" + p.hashCode()   );
		System.out.println("현재 실행되는 객체를 반환:" +  p.getClass() );
		
		//
		
		try {
			Person clonePerson = (Person)p.clone();
			System.out.println(clonePerson);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//finalize
		p = null;
		System.gc(); //가비지컬렉터 동작
		
		
		
		
		
		
		
		
	}
}
