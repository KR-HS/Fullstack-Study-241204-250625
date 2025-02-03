package thread.ex02;

public class MainClass {
	public static void main(String[] args) {
		
		//1개의 객체 1개의 쓰레드
		ThreadTest thread = new ThreadTest();
		thread.start();
		
		System.out.println("메인쓰레드 종료");
	}
}
