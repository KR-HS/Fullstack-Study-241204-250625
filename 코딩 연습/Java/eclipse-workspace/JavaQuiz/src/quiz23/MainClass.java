package quiz23;

public class MainClass {
	public static void main(String[] args) {
		Music m = new Music();
		Video v = new Video();
		Thread thread1 = new Thread(m,"m");
		Thread thread2 = new Thread(v,"v");
		
		thread1.start();
		thread2.start();
	}
}
