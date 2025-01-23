package collection.set;

import java.util.*;

public class HashSetEx {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		// 값의 추가
		set.add("java");
		set.add("database");
		set.add("git");
		set.add("css");
		set.add("java");
		set.add("java");
		
		System.out.println("셋 크기: "+set.size());
		System.out.println(set.toString());
		
		
		// 값 조회 - get메서드가 없고, 반복자를 통해서 하나씩 꺼내봐야 함.
		// 반복자로 변경
		Iterator<String> iter = set.iterator();
		
		// 다음이 있는지 확인하고 반복
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("-".repeat(30));
		
		for(String s:set) {
			System.out.println(s);
		}
		
		// 값의 검색
		if(set.contains("git")) {
			System.out.println("git이 포함되어 있습니다.");
		}
		// 값의 삭제
		// set에서는 값을 매개변수로 넣어서 삭제
		set.remove("java");
		System.out.println(set.toString());
	}
}