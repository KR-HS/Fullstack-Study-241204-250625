package quiz13;

public class MainClass {
	public static void main(String[] args) {
		Marine marine1 = new Marine(0,0);
		Marine marine2 = new Marine(0,0);
		Marine marine3 = new Marine(0,0);
		Tank tank1= new Tank(0,0);
		Tank tank2= new Tank(0,0);
		Tank tank3= new Tank(0,0);
		DropShip ship = new DropShip(0,0);
		
		System.out.println("마린1 정보>> 아머:"+marine1.getArmor()+", 공격력:"+marine1.getAttack()+", hp:"+marine1.getHp());
		marine1.StimPack();
		System.out.println("마린1 정보>> 아머:"+marine1.getArmor()+", 공격력:"+marine1.getAttack()+", hp:"+marine1.getHp());
		System.out.println("마린2 정보>> 아머:"+marine2.getArmor()+", 공격력:"+marine2.getAttack()+", hp:"+marine1.getHp());
		
		System.out.println("-----");
		System.out.println("마린1");
		marine1.location();
		System.out.println("마린2");
		marine1.location();
		System.out.println("-----");
		System.out.println("마린1이동");
		marine1.move(1,1);
		System.out.println("-----");
		System.out.println("마린1");
		marine1.location();
		System.out.println("마린2");
		marine2.location();
		marine1.stop();
		
		System.out.println("탱크1");
		tank1.location();
		
		tank1.changeMode();
		
		System.out.println("드랍쉽 위치");
		ship.location();

		ship.ride(marine1);
		ship.ride(marine1);
		ship.ride(tank1);
		ship.ride(marine1);
		ship.ride(marine1);
		ship.ride(marine1);
	}
	
}
