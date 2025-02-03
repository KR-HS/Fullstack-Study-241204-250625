package thread.yield;

public class MainClass {
	public static void main(String[] args) {
		TestA a =new TestA();
		TestB b = new TestB();
		Thread thread1 = new Thread(a,"A");
		Thread thread2 = new Thread(b,"B");
		
		thread1.start();
		thread2.start();
		
		try{
			Thread.sleep(3000);
			a.worker=false;
			
			Thread.sleep(10000);
			a.worker=true;
		}catch(Exception e) {
			
		}
	}
}
