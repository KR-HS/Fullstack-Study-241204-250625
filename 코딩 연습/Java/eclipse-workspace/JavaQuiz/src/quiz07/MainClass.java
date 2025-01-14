package quiz07;

public class MainClass {
	public static void main(String args[]) {
		Car c1 = new Car("KIA",50);
		Car c2 = new Car("현대");
		
		c1.accel(10);
		c2.accel(50);
		
		c1.run();
		c2.run();
	}
}
