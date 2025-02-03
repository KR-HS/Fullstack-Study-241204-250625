package thread.ex01;

public class ThreadTest implements Runnable{
	// 1. runnable 인터페이스를 상속받아서 사용하는 방법
	// synchronized - 쓰레드가 동기화메서드를 점유할 때, 다른 쓰레드의 침범을 막음
	int num=0;
	@Override
	public /*synchronized*/ void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			if(Thread.currentThread().getName().equals("A")) {
				num++;
			}
			System.out.println(Thread.currentThread().getName() + "num값:"+num);
			// 일시정지
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
