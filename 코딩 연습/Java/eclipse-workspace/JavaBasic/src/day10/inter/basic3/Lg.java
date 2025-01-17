package day10.inter.basic3;

public class Lg implements Printed{

	private String lg ="Life is good";
	
	@Override
	public void print(String document) {
		System.out.println(lg);
		System.out.println("문서내용:"+document);
	}
	
	@Override
	public int copy(int n) {
		System.out.println(lg);
		System.out.println(n+"장 복사를 시작합니다.");
		return n;
	}
}
