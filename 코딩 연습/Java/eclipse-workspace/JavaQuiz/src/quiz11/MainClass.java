package quiz11;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
//		Scanner sc =new Scanner(System.in);
//		System.out.print("만들 캐릭터 수를 입력해주세요:");
//		int n=sc.nextInt();
//		List<Warrior> warriors = new ArrayList<>();
//		List<Sorceress> sorceress = new ArrayList<>();
//		
//		while(n>0) {
//			System.out.print("생성할 캐릭터 유형을 선택해주세요.<1.전사 / 2.마법사>");
//			int job=sc.nextInt();
//			
//			if(job==1) {
//				System.out.print("캐릭터 이름을 입력해주세요:");
//				Warrior w = new Warrior(sc.next());
//				warriors.add(w);
//				System.out.println("-".repeat(30));
//			}
//			else if(job==2) {
//				System.out.print("캐릭터 이름을 입력해주세요:");
//				Sorceress s = new Sorceress(sc.next());
//				sorceress.add(s);
//				System.out.println("-".repeat(30));
//			}
//			else {
//				System.out.println("\n[입력오류] 다시입력");
//				continue;
//			}
//			n--;
//		}
//		
//		warriors.get(0).smash(sorceress.get(0));
//		sorceress.get(0).blizzard(new Player[] {warriors.get(0),warriors.get(warriors.size()-1)});

		
		Warrior p1= new Warrior("전사1");
		Warrior p2= new Warrior("전사2");
		Sorceress p3= new Sorceress("마법사1");
		Sorceress p4= new Sorceress("마법사2");
		Sorceress p5= new Sorceress("마법사3");
		Warrior p6 = new Warrior("전사3");
		
		p6.smash(p1);
		
		
		p3.blizzard(new Player[] {p1,p2,p4,p5});
	}
}
