package quiz08;

public class MainClass {
	public static void main(String args[]) {
		Airplane a= new Airplane("아시아나");
		SuperSonicAp superA= new SuperSonicAp("보잉");
		
		superA.fly();
		
		System.out.println(superA.info());
	}
}
