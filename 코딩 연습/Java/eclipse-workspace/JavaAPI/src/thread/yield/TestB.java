package thread.yield;

public class TestB implements Runnable{

	@Override
	public void run() {
		
		while(true) {
			System.out.println("스레드 B 실행중");
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
