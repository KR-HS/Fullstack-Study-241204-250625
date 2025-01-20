package api.lang.strbuilder;

public class StringBuilderEx {
	public static void main(String[] args) {
		
		
		// 빠른 문자열
		String str = new String("java");
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		System.out.println(str);
		System.out.println(sb);
		
		str  = str+" programming"; // 완전 새로운 문자열을 만들어서 저장
		sb.append(" programming");
		
		// 문자열 중간에 추가 insert
		sb.insert(5,"book ");
		System.out.println(sb);
		
		// 문자열의 변경
		sb.replace(5, 9, "책");
		System.out.println(sb);
		
		// 문자열 삭제 delete
		sb.delete(5, 7); // 5이상 7미만 인덱스 삭제
		System.out.println(sb);
		
		// 빠른 문자열을 > 문자열로 변환
		sb.toString();
		System.out.println("문자열:"+sb);
		
		// 문자열 뒤집기
		sb.reverse();
		System.out.println(sb);
		
		
	}
}
