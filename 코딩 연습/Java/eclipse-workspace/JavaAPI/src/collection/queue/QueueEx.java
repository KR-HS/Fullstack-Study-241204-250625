package collection.queue;
import java.util.*;
public class QueueEx {
	public static void main(String[] args) {
		// 자바에서 기본큐는 LinkedList를 이용해서 사용
		// LinkedList를 Queue인터페이스에 저장하면, 큐처럼 동작
		Queue<Integer> queue = new LinkedList<>();
		
		// 값 추가하기 - offer
		queue.offer(5);
		queue.offer(3);
		queue.offer(4);
		queue.offer(6);
		queue.offer(7);
		
		System.out.println(queue.toString());
		System.out.println("큐의 크기 : "+queue.size());
		
		// 값 제거하기(가장 처음 들어간 요소) - poll
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		// 값 확인하기(가장 처음의 요소) peek
		System.out.println(queue.peek());
		System.out.println(queue.toString());
		
		
		// 큐에 있는 값을 순서대로 꺼내보기
		// 큐가 비어있는지 확인한 후에
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
