package day07.overloading.basic;

public class MainClass {
	public static void main(String args[]){
		
		Basic b = new Basic();
		
		b.abc(1);
		b.abc(3.14);
		b.abc("1",1);
		b.abc(1,"a");
		b.abc('1', "", 0);
	}
}
