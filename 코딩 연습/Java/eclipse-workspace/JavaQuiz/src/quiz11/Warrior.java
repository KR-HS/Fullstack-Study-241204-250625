package quiz11;

public class Warrior extends Player{
	//전사
	// 1. 생성자 - 이름을 전달받아서, hp=1000, mp=500으로 초기화
	public Warrior(String name) {
		this.setName(name);
		this.setHp(1000);
		this.setMp(500);
		
//		this.name=name;
//		this.hp=1000;
//		this.mp=500;
	}
	
	// 2. 으꺠기기술 - 매개변수로 Player를 받습니다.
	// 스킬을 사용하면 나의 mp가 100이 소모
	// 마나가 없으면 스킬을 사용할 수 없습니다.
	// 타격당한 상대방은 hp가 100이 소모가 됩니다.
	public void smash(Player p) {
		if(this.getMp()-100<0) {
			System.out.println("스킬을 사용할 마나가 부족합니다.");
			return;
		}
		System.out.println("-".repeat(20));
		System.out.println("플레이어 "+this.getName()+"이 으깨기 스킬을 사용합니다. (현재마나:"+this.getMp()+")");
		System.out.println("-".repeat(20));
		setMp(this.getMp()-100);
		p.setHp(p.getHp()-100);
		
		System.out.println("플레이어 "+p.getName()+"이 100만큼의 피해를 입었습니다.");
		System.out.println("플레이어 "+p.getName()+"의 남은체력은 "+p.getHp()+"입니다.");
		
		System.out.println("-".repeat(20));
		System.out.println("플레이어 "+this.getName()+"의 스킬 사용 후 남은 마나는 "+this.getMp()+"입니다.");
		System.out.println("-".repeat(20));

		
		
	}
	
}
