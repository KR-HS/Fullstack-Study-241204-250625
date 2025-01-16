package quiz13;

public class DropShip extends Unit{

	// unit담을 배열
	private Unit[] spaceArr=new Unit[8];
	
	// 생성자
	public DropShip(int x,int y) {
		super(x,y);
		setHp(60);
	}
	
	
	// 유닛 태우기 함수(ride)
	public void ride(Unit unit) {
		int empty_space=0;
		for(Unit space:spaceArr) {
			if(space==null) empty_space++;
		}
		if(unit instanceof Tank) {
			if(empty_space>=4) {
				System.out.println("드랍쉽에 탱크를 탑승시킵니다.");
				int count=4;
				for(int i=0;i<spaceArr.length;i++) {
					if(spaceArr[i]==null) {
						spaceArr[i]=unit;
						count--;
					}
					if(count<=0) return;
				}
			}
			else {
				System.out.println("수송선에 공간이 부족합니다.");
				return;
			}
		}
		if(unit instanceof Marine) {
			if(empty_space>=1) {
				System.out.println("드랍쉽에 마린을 탑승시킵니다.");
				int count=1;
				for(int i=0;i<spaceArr.length;i++) {
					if(spaceArr[i]==null) {
						spaceArr[i]=unit;
						count--;
					}
					if(count<=0) return;
				}
			}
			else {
				System.out.println("수송선에 공간이 부족합니다.");
				return;
			}
		}
	}
	
}
