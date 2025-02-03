package thread.ex02;

public class ThreadTest extends Thread {
	// 1. thread클래스를 상속받아서도 사용 가능
	//    - 클래스가 전부 쓰레드기능을 가지게 됨
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(getName()+", "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
