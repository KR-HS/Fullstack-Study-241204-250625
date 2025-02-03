package collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {

	public static void main(String[] args) {
		
		//연결리스트 - ArrayList와 사용방법이 동일함.
		
		//LinkedList<String> list = new LinkedList<>();
		LinkedList<String> list = new LinkedList<>();
		
		list.add("홍길동");
		list.add("홍길자");
		list.add("홍길동");
		list.add("이순신");
		
		System.out.println( list.toString() );
		System.out.println( "리스트크기:" + list.size());
		
		//값 얻기
		String name = list.get(0);
		System.out.println("0번째 위치한 값:" + name);
		
		//값 수정
		list.set(0, "신사임당");
		System.out.println( list.toString() );
		
		//값 삭제
		list.remove(3);
		System.out.println( list.toString() );
		
		//추가적으로 사용할 수 있는 기능
		//앞뒤로 추가하기 기능
		list.addFirst("첫번째 추가");
		list.addLast("마지막에 추가");
		
		System.out.println( list.toString() );
		
		
		System.out.println("앞에서 삭제된 값:" + list.removeFirst() );
		System.out.println("뒤에서 삭제된 값:" + list.removeLast()  );
		
		System.out.println( list.toString() );
		
		
	}
}
