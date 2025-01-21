package api.lang.wrapper;

public class Boxing {

	public static void main(String[] args) {
		
		//기본타입의 객체형 wrapper클래스 라고 합니다.
		
		//boxing - 기본형 => 클래스형 으로 형변환
		int a = 1;
		double b = 3.14;
		char c = 'A';
		boolean d = true;
		
		Integer val1 = new Integer(a);
		Double val2 = new Double(b);
		Character val3 = new Character(c);
		Boolean val4 = new Boolean(d);
		
		Object[] arr = {val1, val2, val3, val4};
		
		//unboxing - 포장된 객체를 다시 기본타입으로 변환하는 작업
		a = val1.intValue();
		b = val2.doubleValue();
		c = val3.charValue();
		d = val4.booleanValue();
		
		
		
		
		
		
		
		
		
	}
}
