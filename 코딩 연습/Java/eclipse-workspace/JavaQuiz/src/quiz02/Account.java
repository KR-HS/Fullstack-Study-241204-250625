package quiz02;
import java.util.*;
public class Account {
	/*
	  Account클래스
	  
		멤버변수
		이름 - String
		비밀번호 - String
		잔액 - int
		
		생성자
		(이름, 비밀번호, 잔액) 을 받아서 초기화 해주는 생성자 1개
		
		메서드
		입금기능 - deposit(int) : 반환 void - 잔액에 매개변수를 누적하는 기능
		출금기능 - withDraw(int) : 반환 int - 사용자에게 비밀번호를 입력받아서, 비밀번호가 일치하면, 잔액을 차감해하고, 출금값을 반환하는 기능
		잔액조회 - getBalance() : 반환 int - 잔액을 반환하는 기능
		
	*/
	
	Scanner sc = new Scanner(System.in);
	String name;
	String pw;
	int acc=0;
	
	Account(String c_name,String password, int money){
		System.out.println("계좌를 생성했습니다.");
		name=c_name;
		pw=password;
		acc=money;
		System.out.println("현재 계좌의 잔액은 "+money+"원 입니다.");
	}
	
	public void deposit(int money) {
		System.out.println(money+"원을 입급합니다.");
		acc+=money;
	}
	
	public int withDraw(int money) {
		
		System.out.print("패스워드를 입력하세요:");
		String pass= sc.next();
		
		if(!pw.equals(pass)) { 
			System.out.println("패스워드가 일치하지 않습니다.");
			return -1;
		}
		if(acc-money<0) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("현재 계좌의 잔액은 "+acc+"원 입니다.");
			return -1;
		}
		else {
			System.out.println("현재 계좌에서"+money+"원을 인출했습니다.");
			acc-=money;
			System.out.println("현재 계좌의 잔액은 "+acc+"원 입니다.");
			
			return acc;
		}
	}
	
	public int getBalance() {
		System.out.println("현재 계좌의 잔액은 "+acc+"원 입니다.");
		return acc;
	}
}
