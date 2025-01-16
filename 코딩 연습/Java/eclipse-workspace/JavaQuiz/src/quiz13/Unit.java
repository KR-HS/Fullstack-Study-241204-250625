package quiz13;

public abstract class Unit {
	// 변수선언
	private int x=0;
	private int y=0;
	private int hp;
	
	// 생성자
	public Unit(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//setter
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	//getter
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHp() {
		return hp;
	}
	
	
	// 공통 함수 : 현재좌표출력(location) / 좌표 이동(move) / 정지(stop)
	public void location() {
		System.out.printf("현재 좌표는 [%d,%d]입니다.\n",x,y);
	};
	
	
	public void move(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
	public void stop() {
		System.out.printf("좌표 [%d,%d]에 정지합니다.\n",x,y);
	}
}
