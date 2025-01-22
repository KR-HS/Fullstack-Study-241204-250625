package quiz20;
import java.util.*;
public class ListQuiz03 {
	public static void main(String[] args) {
		
		/*
		 * 
		 * 회원 정보 프로그램 시뮬레이터
		 * 
		 * 무한반복문 안에서 메뉴를 입력받고, 해당 메뉴에 알맞은 내용을 채워 넣으면 됨
		 * 
		 * [메뉴] 
		 * 1. 유저등록, 2. 전체회원정보 출력 , 3.회원정보 검색, 
		 * 4. 회원정보 삭제 , 5.프로그램종료
		 * 
		 * 
		 * 1. 스캐너로 name, age 입력받아서 User객체를 리스트에 추가
		 * 2. 모든 회원정보 출력
		 * 3. 찾을 이름을 입력받아서, 이름이 있으면, 이름과 나이를 출력
		 *   찾는 이름이 없으면 "~~님은 목록에 없습니다.""~~를 출력
		 * 4. 삭제할 이름을 입력받아서, 동일한 이름을 가진 회원이 있으며 USER삭제
		 * 5. 종료
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		List<User> list = new ArrayList<>();
		outerloop:while(true) {
			System.out.println("[메뉴] 1. 유저등록 // 2. 전체회원정보출력 // 3.회원정보검색 // 4. 회원정보삭제 // 5.프로그램종료");
			System.out.print("메뉴 입력 >> ");
			int menu=0;
			String input = sc.next();
			if(input.length()>1||input.length()<1) {
				System.out.println("입력오류 다시 입력해주세요.");
				continue;
			}
			else {
				char[] c = input.toCharArray();
				if(c[0]>='0'&&c[0]<='9') {
					menu = (int)(c[0]-'0');					
				}
				else {
					System.out.println("입력오류 다시 입력해주세요.");
					continue;
				}
			}
			switch(menu){
			case 1:
				System.out.println("-".repeat(50));
				System.out.println("유저 등록을 시작합니다.");;
				System.out.print("유저 이름 입력>>");
				String name= sc.next();
				System.out.print("유저 나이 입력>>");
				int age = sc.nextInt();
				User u = new User(name,age);
				list.add(u);
				System.out.println("유저등록을 완료하였습니다.");
				break;
			case 2:
				System.out.println("-".repeat(50));
				System.out.println("전체 회원정보를 출력합니다.");
				for(User user : list) {
					System.out.println("이름 : "+user.getName()+", 나이:"+user.getAge());
				}
				break;
			case 3:
				System.out.print("찾으시려는 이름을 입력해주세요>>");
				String search=sc.next();
				for(User user : list) {
					if(user.getName().equals(search)) {
						System.out.println("검색한 이름을 찾았습니다. 회원정보를 출력합니다.");
						System.out.println("이름 : "+user.getName()+", 나이:"+user.getAge());
						continue outerloop;
					}
				}
				System.out.println(search+"님은 목록에 없습니다.");
				break;
			case 4:
				System.out.print("삭제하려는 회원님의 이름을 입력해주세요.");
				String del_name = sc.next();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getName().equals(del_name)) {
						list.remove(i);
						System.out.println(del_name+"님의 회원정보를 성공적으로 삭제했습니다.");
						continue outerloop;
					}
				}
				System.out.println(del_name+"님은 목록에 없습니다.");
				
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return; 
				
			default:
				System.out.println("[입력 오류] 다시 입력해주세요.");
				continue;
			}
		}
	}
}
