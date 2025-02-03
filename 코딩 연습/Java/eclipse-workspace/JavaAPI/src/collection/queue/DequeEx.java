package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeEx {

	public static void main(String[] args) {
		
		//양방향 큐
		Deque<Integer> queue = new ArrayDeque<>();
		
		//뒤에서 추가하기
		queue.offerLast(3);
		queue.offerLast(2);
		queue.offerLast(1);
		queue.offerLast(4);
		queue.offerLast(5);
		
		System.out.println( queue.toString() );
		
		//앞에서 꺼내기
		System.out.println( queue.pollFirst() );
		System.out.println( queue.pollFirst() );
		
		
		System.out.println( queue.toString());
		
		//앞에서 추가하기
		queue.offerFirst(10);
		queue.offerFirst(20);
		queue.offerFirst(30);
		System.out.println( queue.toString());
		
		//뒤에서 꺼내기
		System.out.println( queue.pollLast() );
		System.out.println( queue.toString());
		
		//peek() - 값만 확인하기.
		
		
		
		
		
		
		
	}
}
