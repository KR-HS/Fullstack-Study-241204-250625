package quiz13;

public class Tank extends Unit{

	// 시즈모드 변수 선언 (true: 시즈모드 / false : 일반모드)
	private boolean seizeMode=false;
	
	
	// 생성자
	public Tank(int x,int y) {
		super(x,y);
		setHp(100);
	}
	
	//getter
	public boolean getSeizeMode() {
		return seizeMode;
	}
	
	public void changeMode() {
		System.out.println(seizeMode?"시즈모드를 해제합니다.":"시즈모드로 전환합니다.");
		seizeMode=!seizeMode;
	}
}
