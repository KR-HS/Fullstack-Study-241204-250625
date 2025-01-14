package day08.modi.protect.pac2;

import day08.modi.protect.pac1.A;

public class C extends A{

	public C() {
//		A a = new A();
//		a.bool = true;
//		a.method();
		
		// super를 통한 접근은 가능
		super.bool = true;
		super.method();
	}
}
