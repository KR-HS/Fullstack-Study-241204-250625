package quiz11;
public class Sorceress extends Player{
	// 마법사
	
		// 1. 생성자 - 이름을 전달받아서, hp=1000, mp=500으로 초기화
		public Sorceress(String name) {
			this.setName(name);
			this.setHp(1000);
			this.setMp(500);
			
//			this.name=name;
//			this.hp=1000;
//			this.mp=500;
		}
	
		// 2. 블리자드스킬 - 광역공격기
		// 블리자드 스킬은 마나 200을 소모
		// 마나가 없으면 스킬을 사용할 수 없음
		// 배열안에 들어 있는 모든 객체에 5~15사이의 랜덤한 피해를 한번 발생을 시킵니다.
		// 타격당한 플레이어는 체력이 피해와 동일하게 소모되어야함.
		// 타격당한 플레이어의 이름을 출력
		public void blizzard(Player[] players) {
			if(this.getMp()-200<0) {
				System.out.println("스킬을 사용할 마나가 부족합니다.");
				return;
			}
			System.out.println("-".repeat(20));
			System.out.println("플레이어 "+this.getName()+"이 블리자드 스킬을 사용합니다. (현재마나 :"+this.getMp()+")");
			System.out.println("-".repeat(20));
			setMp(this.getMp()-200);
			for(Player p:players) {
				// instanceof 키워드 사용  - 객체 타입 확인
				if(p instanceof Warrior) System.out.println("전사");
				else if(p instanceof Sorceress) System.out.println("법사");
				
				int damage=(int)(Math.random()*11)+5;
				p.setHp(p.getHp()-damage);
				System.out.println("플레이어 "+p.getName()+"이 "+damage+"만큼 피해를 입었습니다. (남은 Hp:"+p.getHp()+")");
			}
			System.out.println("-".repeat(20));
			System.out.println("플레이어 "+this.getName()+"의 스킬 사용 후 남은 마나는 "+this.getMp()+"입니다.");
			System.out.println("-".repeat(20));
			
		}
	
}
