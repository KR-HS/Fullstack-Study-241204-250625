package day10.inter.basic3;

public class MainClass {
	public static void main(String[] args) {
		
//		Lg lg = new Lg();
//		lg.print("LG로 실행함");
//		lg.copy(5);
		
		Printed pt = new Samsung();//new Lg();
		pt.print("print 실행함");
		pt.copy(5);
	}
}
