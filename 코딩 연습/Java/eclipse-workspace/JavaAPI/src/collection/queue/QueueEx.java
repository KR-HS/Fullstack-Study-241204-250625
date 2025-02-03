package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {
		
		//자바에서 기본큐는 LinkedList를 이용해서 사용합니다.
		//LinkedList를 Queue인터페이스 저장하면, 큐 처럼 동작합니다.
		Queue<Integer> queue = new LinkedList<>();
		
		//값을 추가하기 offer
		queue.offer(5);
		queue.offer(3);
		queue.offer(4);
		queue.offer(6);
		queue.offer(7);
		
		System.out.println( queue.toString() );
		System.out.println( "큐의 크기:" + queue.size() );
		
		//값을 제거하기 poll
		System.out.println(  queue.poll()  );
		System.out.println(  queue.poll()  );
		System.out.println( queue.toString());
		
		//앞에서 꺼낸값을 확인 peek
		System.out.println( queue.peek() );
		System.out.println( queue.toString());
		
		
		//큐에 있는 값을 순서대로 꺼내보기
		//큐가 비었는지 확인한 후에 꺼냄
		//큐가 비었으면 true, 값이 있다면 false
		while( queue.isEmpty() == false ) {
			System.out.println( queue.poll() );
		}
		
		
		
		
		
		
		
	}
}
