package day08.modi.protect.pac1;

public class A {
	
	private int a;
	/*
	 * protected 접근제어자
	 * default와 마찬가지로 같은 패키지에서만 사용할 수 있음
	 * 단, 패키지가 다르더라도 super키워드 참조가 됨
	 */
	
	protected boolean bool;


	protected A() {}
	
	protected void method() {}
}
