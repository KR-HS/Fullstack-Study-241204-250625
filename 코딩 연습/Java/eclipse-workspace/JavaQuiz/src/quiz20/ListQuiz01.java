package quiz20;

import java.util.*;
public class ListQuiz01 {

	public static void main(String[] args) {
		//1. 리스트에 1~30까지의 값을 순서대로 저장.
		
		List<Integer> iList = new ArrayList<>();
		for(int i=1;i<=30;i++) {
			iList.add(i);
		}
		
		// 2. 리스트에서 짝수 요소 값만 가로로 출력
		
		for(int i:iList) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		for(int i=0;i<iList.size();i++) {
			if(iList.get(i)%2==0) {
				System.out.print(iList.get(i)+" ");
			}
		}
		System.out.println();
	}
}
