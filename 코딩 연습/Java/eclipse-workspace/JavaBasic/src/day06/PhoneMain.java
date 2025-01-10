package day06;

public class PhoneMain {
	public static void main(String args[]) {
		
		Phone phone = new Phone();
		Phone phone1= new Phone(20000);
		Phone phone2 = new Phone("아스트로","빨강");
		Phone phone3 = new Phone(50000,"갤럭시","블루");
		
		phone.info();
		phone1.info();
		phone2.info();
		phone3.info();
	}
}
