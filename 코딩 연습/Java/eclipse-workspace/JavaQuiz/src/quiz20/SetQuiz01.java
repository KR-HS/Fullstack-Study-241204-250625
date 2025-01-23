package quiz20;

import java.util.*;
public class SetQuiz01 {
	public static void main(String args[]) {
		
		/*
		 * 
		 * 로또 번호 자동 생성기
		 * Set을 이용해서 6개의 랜덤한 로또 번호를 만들어내는 프로그램 코드를 작성
		 * 
		 */
		
		Set<Integer> set = new HashSet<>();
		
		while(set.size()!=6) {
			set.add((int)(Math.random()*45)+1);
		}
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.printf("%2d ",iter.next());
		}
		System.out.println();
		
		

	}
}
