package PR;
import java.util.*;
import java.util.Map.Entry;
public class MapQuiz02 {
	public static void main(String[] args) {
		/*
		메뉴관리 시뮬레이터
		
		무한 반복문안에서 음식 메뉴를 입력받고, 해당 메뉴에 알맞은 내용을 채워 넣어주면 됩니다.
		
		* 음식메뉴는 key로 등록하고 가격은 value로 등록합니다.
		음식 메뉴 정보
		1. 신규 메뉴 등록 2. 메뉴판 전체 보기 3. 메뉴판 수정 4. 메뉴판 삭제 5. 프로그램 종료
		
		1. 이미 등록된 메뉴인지 확인 후에 메뉴 등록
		2. 메뉴와 가격을 전부 출력
		3. 변경할 메뉴를 받아서 메뉴가 있다면 가격을 수정
		4. 변경할 메뉴를 받아서 메뉴가 있다면 삭제
		5. 프로그램 종료
		*/
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> map = new HashMap<>();
		while(true) {
			System.out.println("[음식메뉴 정보] 1. 신규 메뉴 등록 2. 메뉴판 전체 보기 3. 메뉴판 수정 4. 메뉴판 삭제 5. 프로그램 종료");
			System.out.print("입력>>");
			// 입력 부분 예외 처리
			char[] input=sc.nextLine().toCharArray();
			int menu=0;
			if(input.length!=1) {
				System.out.println("메뉴 입력 오류!");
				continue;
			}
			else {
				if(input[0]>='1'&&input[0]<='5') menu=(int)(input[0]-'0');
				else {
					System.out.println("메뉴 입력 오류!");
					continue;
				}
			}
			// 메뉴별 기능
			switch(menu) {
				case 1:
					System.out.print("음식메뉴>>");
					String food = sc.nextLine();
					if(map.containsKey(food)) {
						System.out.println("이미 등록된 메뉴 입니다. 수정 메뉴를 이용해주세요.");
						continue;
					}else {
						System.out.print("가격>>");
						int price = Integer.parseInt(sc.nextLine());
						map.put(food, price);
						System.out.println("음식을 성공적으로 등록했습니다!!");
					}
					break;
				case 2:
					if(map.isEmpty()) {
						System.out.println("등록된 메뉴가 없습니다.");
						continue;
					}
					Set<Entry<String,Integer>> foodMenu = map.entrySet();
					System.out.println("[메뉴]");
					for(Entry<String,Integer> fp:foodMenu) {
						System.out.println(fp.getKey()+"\t가격:"+fp.getValue());
					}
					break;
				case 3:
					System.out.print("가격을 변경할 음식>>");
					String mFood = sc.nextLine();
					if(map.containsKey(mFood)) {
						System.out.print("가격>>");
						int price = Integer.parseInt(sc.nextLine());
						map.put(mFood, price);
						System.out.println(mFood+"메뉴의 가격을 수정합니다.");
					}else {
						System.out.println("변경할 메뉴가 존재하지 않습니다.");
						continue;
					}
					break;
				case 4:
					System.out.print("삭제할 음식>>");
					String dFood = sc.nextLine();
					if(map.containsKey(dFood)) {
						System.out.println(dFood+"메뉴를 삭제합니다.");	
						map.remove(dFood);
					}else {
						System.out.println("삭제할 메뉴가 존재하지 않습니다.");
						continue;
					}
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					System.exit(1);
				default:
					System.out.println("메뉴 입력 오류");
			}			
		}
		
	}
}
