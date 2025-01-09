package day05;
import java.util.*;

public class StudentManager {
	static Scanner sc = new Scanner(System.in);
	
	static String[] nameList=new String[100];
	static int[] ageList=new int[100];
	static int count=0; // 고객수
	static int index=-1; //위에 있는 배열을 조회하는 위치(포인터) 
	
	static void add() {
		// 입력을 받아 배열에 추가
		System.out.print("이름>");
		String name=sc.next();
		System.out.print("나이>");		
		int age = sc.nextInt();
		
		nameList[count]=name;
		ageList[count]=age;
		count++; // 고객수 증가
		
	}
	
	static void printInfo() {
		System.out.println("이름 : "+nameList[index]);
		System.out.println("나이 : "+ageList[index]);
	}
	
	static void alterInfo() {
		System.out.print("수정할 이름>");
		String name=sc.next();
		System.out.print("수정할 나이>");		
		int age = sc.nextInt();
		nameList[index]=name;
		ageList[index]=age;
	}
	
	static void deleteInfo() {
		if(index==count-1) {
			nameList[index]="";
			ageList[index]=0;
			index--;
		}
		else {
			for(int i=index;i<count-1;i++) {
				nameList[i]=nameList[i+1];
				ageList[i]=ageList[i+1];
			}
			nameList[count-1]="";
			ageList[count-1]=0;
		}
		count--;
		
	}
	public static void main(String args[]) {
		//예를 들어서 index=0이면, 배열의 0번쨰 위치를 조회
		loop:while(true) {
			
			System.out.println("[현재고객수]:"+count);
			System.out.println("[조회위치]:"+index);
			System.out.println("[메뉴] 1.추가, 2.이전정보, 3.다음정보, 4.현재정보, 5.정보수정, 6.정보삭제, 7.프로그램종료");
			System.out.print("메뉴입력>");
			String menu=sc.next();
			System.out.println("------------------------------------------");
			
			switch(menu) {
				case "1":
					if(count<nameList.length-1) {
						System.out.println("==== 회원 정보를 입력합니다=====");
						add();
						System.out.println("회원정보 입력 성공!!");
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("회원정보를 추가 할 수 없습니다.");
						System.out.println("------------------------------------------");
					}
					break;
					
				case "2":
					System.out.println("==== 이전 회원 정보를 출력합니다=====");
					if(index>0) { 
						index--;
						printInfo();
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("<이전 정보는 없습니다.>");
						System.out.println("------------------------------------------");
					}
					break;
					
				case "3":
					System.out.println("==== 다음 회원 정보를 출력합니다=====");
					if(index<count-1) { 
						index++;
						printInfo();
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("<다음 정보는 없습니다.>");
						System.out.println("------------------------------------------");
					}
					break;
					
				case "4":
					System.out.println("==== 현재 회원 정보를 출력합니다=====");
					if(index>=0) {
						printInfo();
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("<현재 정보는 없습니다.>");
						System.out.println("------------------------------------------");
					}
					break;
					
				case "5":
					if(index>=0) {
						System.out.println("==== 정보를 수정합니다=====");
						alterInfo();
						System.out.println("==== 정보를 성공적으로 수정했습니다=====");
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("수정할 정보가 없습니다.");
					}
					break;
					
				case "6":
					// 현재 삭제하려는 index위치부터 ~뒤에 있는 배열요소를 당겨와서 덮어 씌웁니다.
					if(index>=0) {
						deleteInfo();
						System.out.println("==== 정보를 성공적으로 삭제했습니다=====");
						System.out.println("------------------------------------------");
					}
					else {
						System.out.println("<삭제할 정보가 없습니다.>");
						System.out.println("------------------------------------------");
					}
					break;	
					
				case "7":
					System.out.println("프로그램을 종료합니다.");
					return;				
					
				default:
					System.out.println("<<입력오류 -- 다시 입력해주세요-->>");
					System.out.println("------------------------------------------");
					break;
			
			}
			
			
		}
	}
}
