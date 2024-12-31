package day02;

public class DataTypeEx02 {
	public static void main(String args[]) {
		
		//단일문자 저장 char타입
		char c1 = 'A'; // 2byte
		char c2 = 65;
		
		System.out.println(c1);
		System.out.println(c2);
		
		char c3 = '가';
		char c4 = 44032;
		char c5 = '\uAC00'; // 유니코드 값으로 표현도 됨
		
		// 문자를 통일하기 위해 유니코드 -> 2byte크기로 확장하고 65536개의 문자 사용가능
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
		System.out.println("---------------------------");
		
		//문자열
		String s1 = "내 친구";
		String s2 = " 홍길동은 ";
		String s3 = "말썽꾸러기이다. ~~";
		
		System.out.println(s1+s2+s3);
		System.out.println("문자열 s1의 길이 : "+s1.length());
		
		// 문자열과 다른 데이터타입의 + 연산
		System.out.println(100+200);
		System.out.println("100"+200); // 문자열에 다른 타입이 붙으면 문자열이 됨.
		System.out.println(100+200+"300");
		System.out.println("100"+200+3.14);
		
		System.out.println("A"+10);
		System.out.println('A'+10);
		
		
	}

	private static char[] type() {
		// TODO Auto-generated method stub
		return null;
	}
}
