package thread.ex01;

public class MainClass2 {
	public static void main(String[] args) {
		// N개의 객체, N개의 쓰레드로 각자 실행
		
		ThreadTest th1 = new ThreadTest();
		ThreadTest th2 = new ThreadTest();
		
		Thread thread1 = new Thread(th1,"A");
		Thread thread2 = new Thread(th2,"B");
		
		thread1.start();
		thread2.start();
		
		System.out.println("메인쓰레드 종료");
	}
}
