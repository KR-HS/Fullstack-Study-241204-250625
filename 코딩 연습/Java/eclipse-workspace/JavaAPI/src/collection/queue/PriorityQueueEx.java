package collection.queue;
import java.util.*;
public class PriorityQueueEx {
	public static void main(String[] args) {
		
		// 값을 자동 정렬해서 추가
		Queue<Integer> queue = new PriorityQueue<>();
		
		//값 뒤에 추가
		queue.offer(4);
		queue.offer(5);
		queue.offer(3);
		queue.offer(2);
		queue.offer(1);
		System.out.println(queue.toString());
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		System.out.println("-".repeat(30));
		
		Queue<User> que = new PriorityQueue<>();
		
		/*
		 * 우선순위 큐가 순서를 확인할 때 compareTo메서드의 존재여부를 확인
		 * 
		 * compareTo메서드에 정의된 순서에 따라 우선순위 값을 지정
		 * 
		 * 객체에 comparable인터페이스를 상속받아서 compareTo메서드를 오버라이딩
		 */
		
		// 문자열 비교
		// a.compareTo(b) -> a문자열의 값-b문자열의 값
		
		System.out.println("홍길동".compareTo("홍길자"));
		
		
		que.offer(new User("홍길동",10));
		que.offer(new User("홍길자",30));
		que.offer(new User("이순신",20));
		que.offer(new User("신사임당",5));
		
		System.out.println(que.toString());
		System.out.println(que.poll().toString());
		System.out.println(que.poll().toString());
		System.out.println(que.poll().toString());
		System.out.println(que.poll().toString());
		
		
	}
}
