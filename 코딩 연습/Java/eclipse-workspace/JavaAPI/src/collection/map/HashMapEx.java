package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		//<키에 대한 타입, 값에 대한 타입>
		//HashMap<Integer, String> map = new HashMap<>();
		Map<Integer, String> map = new HashMap<>();
		
		//맵에 값을 추가
		map.put(1, "홍길동");
		map.put(2, "이순신");
		map.put(3, "홍길자");
		map.put(4, "홍길동");
		
		System.out.println("맵의 크기:" + map.size() );
		System.out.println( map.toString() );
		
		//맵은 같은 key를 저장했을 경우, key에 대한 value를 수정합니다.
		map.put(4, "신사임당");
		System.out.println( map.toString() );
		
		//값을 얻기 - 키를 주면, 값을 반환을 합니다.
		String value = map.get(3);
		System.out.println( "3번 키에 대한 값은:" + value);
		
		//맵은 순서가 있지는 않기 때문에, 반복을 돌리려면 반복자를 활용해야 합니다.
		
		//keySet -> key을 set으로 반환시킴
		Set<Integer> keySet = map.keySet();
		
		for(Integer key : keySet) {
			System.out.println("키:" + key + ", 값:" + map.get(key)  );
		}
		
		System.out.println("------------------------------------------");
		//EntrySet -> key와, value 통째로 꺼내줌
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		//엔트리 안에는 key, value를 얻는 함수가 있습니다.
		for(Entry<Integer, String> entry : entrySet ) {
			System.out.println( entry.getKey() + ", " + entry.getValue());
		}
		
		
		//map에 있는 key의 유무 확인
		if(map.containsKey(1)) {
			System.out.println( "1번 키는 이미 존재함");
		}
		
		//map의 삭제
		map.remove(1);
		System.out.println( map.toString() );
		
		
		
		
		
		
		
	}
}
