package day08.super_.basic1;

public class Child extends Parent{

	//아무것도 안적어도 생략.
//	Child(){
//		super();
//	}
	
	// 부모님의 기본생성자가 없으면, 상속 받았을때 , 강제로 생성자 연결을 해야함.
	Child(){
		super("박xx","김xx");
		
	}
}
