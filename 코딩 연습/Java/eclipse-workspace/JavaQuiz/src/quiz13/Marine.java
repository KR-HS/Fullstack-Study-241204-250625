package quiz13;

public class Marine extends Unit{
	private static int attack=6;
	private static int armor=0;
	
	
	//생성자
	public Marine(int x,int y) {
		super(x,y);
		setHp(60);
	}
	
	//getter
	public int getAttack() {
		return attack;
	}
	
	public int getArmor() {
		return armor;
	}
	
	// attack 변수 값을 1증가시키는 StimPack함수
	public void StimPack() {
		attack++;
		System.out.println("마린의 공격력을 1 올립니다.(현재 공격력:"+attack+")");
		
	}
	
	
	
}
