package api.lang.strbuilder;

public class StringBuilderEx02 {
	public static void main(String[] args) {
		
		
		// 스트링과 스트링 빌더의 시간차이
		long start = System.currentTimeMillis();
		// 문자열 더하기 30만번
		String str ="";
		for(int i=0;i<=300000;i++) {
			str+="a";
		}
		long end = System.currentTimeMillis();
		
		System.out.println("수행시간 :"+(end-start)*0.001);
		
		
		
		long start1 = System.currentTimeMillis();
		// 문자열 더하기 30만번
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<=300000;i++) {
			sb.append("a");
		}
		long end1 = System.currentTimeMillis();
		
		System.out.println("수행시간 :"+(end1-start1)*0.001);
		
	}
}
