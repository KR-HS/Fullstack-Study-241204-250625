package day10.final_;

//final 클래스는 상속 불가
public /* final */ class Parent {
	public void method01() {};
	public final void method02() {}; // final 메서드는 오버라이딩 금지
}
