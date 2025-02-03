package ramda.anomymous.basic;

//인터페이스 선언
interface Car {
	void run();
}
//카를 구현하는 클래스
class Tico implements Car {
	@Override
	public void run() {
		System.out.println("티코~");
	}
}

public class Garage {
	
	//public Car car = new Tico();
	//딱 한번만 사용하고, 재활용 할 생각이 없는 클래스는 익명객체로 생성할 수 있음
	public Car car = new Car() {
		
		@Override
		public void run() {
			System.out.println("익명객체 티코 입니다~@");
		}
	};
	
	
	
	public static void main(String[] args) {
		
		Garage g = new Garage();
		g.car.run();
		
	}
	
	
	
}
