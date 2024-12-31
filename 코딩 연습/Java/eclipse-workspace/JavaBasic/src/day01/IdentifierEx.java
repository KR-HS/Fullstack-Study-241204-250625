package day01;

//클래스 앞글자는 대문자
public class IdentifierEx { 
	public static void main(String args[]) {

		int age=10;
		int Age=20; // 대소문자 구분
		System.out.println(age);
		System.out.println(Age);
		
		//---------------------------------------
		// 카멜표기법
		int phonenumber=3; // x
		int phoneNumber=4; // o
		// 공백은 사용 x - 굳이 공백을 쓸거라면 _(언더바)사용
		// int phone number=5; 
		
		System.out.println(phonenumber);
		System.out.println(phoneNumber);
		
		//------------------------------------------
		// 키워드로는 변수명을 지을수 없음.
		//	int class=10;
		//	int public =20 ;
		
		
		
	}
}
