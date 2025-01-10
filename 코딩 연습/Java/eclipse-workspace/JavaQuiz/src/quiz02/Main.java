package quiz02;

public class Main {
	public static void main(String args[]) {
		// tv객체 생성
//		TV tv = new TV();
//		tv.info();
//		
//		// tv채널변경
//		tv.changeChannel(10);
//		tv.info();
//		
//		// tv켜기
//		tv.power();
//		tv.info();
//		
//		// tv채널변경
//		tv.changeChannel(10);
//		tv.info();
//		
//		// tv끄기
//		tv.power();
//		tv.info();
		
		//---------------------------------------------
		
		Account account = new Account("홍길동","1234",10000);
		int remain=0;
		
		remain=account.withDraw(100000);
		System.out.println(remain==-1?"":remain);
		
		account.deposit(2000);
		
		account.getBalance();
		
		remain=account.withDraw(100);
		System.out.println(remain==-1?"":remain);
		
	}
}
