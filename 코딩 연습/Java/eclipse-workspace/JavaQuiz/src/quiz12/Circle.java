package quiz12;

public class Circle extends Shape {
	private int r;
	//원형은 생성될 때 이름과, 반지름의 길이를 받도록 처리하고,
	public Circle(String name, int r) {
		super(name);
		this.r=r;
	}
	//getArea()는 원형의 넓이를 계산하도록 오버라이딩 처리
	@Override
	public double getArea() {
		return r*r*Math.PI;
	}
	//main에서 확인
}
