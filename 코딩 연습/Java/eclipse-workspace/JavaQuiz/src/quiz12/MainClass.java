package quiz12;

public class MainClass {
	public static void main(String[] args) {
		
		Shape circle = new Circle("원1",5);
		Shape rect = new Rect("정사각1",3);
		
		System.out.println(circle.getName()+">> 넓이 :"+circle.getArea());
		System.out.println(rect.getName()+">> 넓이 :"+rect.getArea());
	}
}
