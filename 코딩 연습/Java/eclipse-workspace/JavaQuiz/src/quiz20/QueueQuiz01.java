package quiz20;
import java.util.*;
public class QueueQuiz01 {
	public static void main(String[] args) {
		/*
		 * 은행 대기열 시뮬레이터
		 * 
		 * Queue 인터페이스와 LinkedList를 활용하여 대기열을 관리하세요.
		 * 손님 정보는 Customer라는 클래스로 생성하세요
		 * Customer은 name, arrivalTime을 가지고 있습니다.
		 * arrivalTime은 업무처리 소요시간 입니다
		 * 
		 * 손님은 60%의 확률로 도착하고 (랜덤.nextInt(100) < 60)
		 * 대기열이 비어있지 않을 때, 50%확률로 업무가 처리됩니다. (랜덤.nextInt(100) < 50)
		 * 
		 * 30회 시뮬레이터를 거쳤을 때, 총 소요시간과, 처리하지 못한 손님을 출력해 주세요.
		 * 
  			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			는 프로그램을 1초 정지 시키는 코드입니다
		 * 
		 * 
		 */
		Random random = new Random();
		int time= 0;
		Queue<Customer> customer = new LinkedList<>();
		for(int i=0;i<30;i++) {
			System.out.println(i+1+"번째 실행");
			System.out.println(customer.toString());
			if(random.nextInt(100)<60) {
				customer.offer(new Customer("customer"+i,(int)(Math.random()*3)+1));
			}
			if(!customer.isEmpty()) {
				if(random.nextInt(100)<50) {
					time +=customer.poll().getArrivalTime();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("총 소요시간:"+time);
		System.out.println("==== 처리하지 못한 손님 =====");
		while(!customer.isEmpty()) {
			Customer cus= customer.poll();
			System.out.println("손님 이름:"+cus.getName());
		}
		
	}
}
