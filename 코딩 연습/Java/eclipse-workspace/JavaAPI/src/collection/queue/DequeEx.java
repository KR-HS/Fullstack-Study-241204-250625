package collection.queue;
import java.util.*;
public class DequeEx {
	public static void main(String[] args) {
		
		// 양방향 큐
		Deque<Integer> deque = new ArrayDeque<>();
		
		// 뒤에서 추가하기
		deque.offerLast(3);
		deque.offerLast(2);
		deque.offerLast(1);
		deque.offerLast(4);
		deque.offerLast(5);
		
		System.out.println(deque.toString());
		
		// 앞에서 꺼내기
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollFirst());
		
		System.out.println(deque.toString());
		
		// 앞에서 추가하기
		deque.offerFirst(10);
		deque.offerFirst(20);
		deque.offerFirst(30);
		System.out.println(deque.toString());
		
		// 뒤에서 꺼내기
		System.out.println(deque.pollLast());
		System.out.println(deque.pollLast());
		
		System.out.println(deque.toString());
		
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		
	}
}
