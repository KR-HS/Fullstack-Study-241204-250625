package quiz12;

public class Rect extends Shape {
	private int len;

	//사각형은 생성될 때 이름과, 변의 길이를 받도록 처리하고,
	public Rect(String name,int len) {
		super(name);
		this.len=len;
	}

	//getArea()는 사각형의 넓이를 계산하도록 오버라이딩 처리
	@Override
	public double getArea() {
		return len*len;
	}
	//main에서 확인

	
}
