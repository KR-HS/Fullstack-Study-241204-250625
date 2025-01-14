package day08.modi.member.pac1;

public class A {
	public A(int i){}
	A(String s){}
	private A(boolean b){} // 외부에서 객체생성을 못하게 할때 . 생성자 private
	
	
	////////////////////////////////////////
	
	public int a;
	int b;
	private int c;
	
	//생성자
	public A() {
		a=1;
		b=2;
		c=3;
		method01();
		method02();
		method03();
	}
	
	
	public void method01() {
	}
	
	void method02() {
		
	}
	
	private void method03() {
		
	}
}
