package regex.pattern;

public class RegexEx01 {
	public static void main(String[] args) {
		String info="홍길자|30|서울시 강남구|010-1234-4567";
		// 전화번호 형식만 찾아서 **** 암호처리
		
		String pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		String result=info.replaceAll(pattern, "***-****-****");
		
		System.out.println(result);
	}
}
