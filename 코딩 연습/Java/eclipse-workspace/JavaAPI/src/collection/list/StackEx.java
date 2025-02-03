package collection.list;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		//컬렉션을 문자열 형태로 보고 싶으면 toString메서드를 사용합니다.
		System.out.println( stack.toString()  );
		
		//pop - 값을 제거하면서, 제거한 값을 반환
		int a = stack.pop(); 
		System.out.println(a);
		
		
		//peek - 값을 제거하지 않고, 반환
		System.out.println( stack.toString()  );
		System.out.println( stack.peek() );
		System.out.println( stack.peek() );
		System.out.println( stack.peek() );
		
		//isEmpty - 스택이 비엇으면 true, 아니면 false
		if( stack.isEmpty() ) {
			System.out.println("스택이 비었음");
		} else {
			System.out.println("스택이 비어있지 않음");
		}
		
		
		
		
		
		
		
		
	}
}
