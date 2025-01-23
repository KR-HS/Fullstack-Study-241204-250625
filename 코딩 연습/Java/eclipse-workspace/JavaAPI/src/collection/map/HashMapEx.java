package collection.map;
import java.util.*;
import java.util.Map.Entry;


public class HashMapEx {
	public static void main(String[] args) {
		// <키에 대한 타입, 값에 대한 타입>
		Map<Integer,String> map = new HashMap<>();
		
		// 맵에 값을 추가
		
		map.put(1, "홍길동");
		map.put(2, "이순신");
		map.put(3, "홍길자");
		map.put(4, "홍길동");
		
		System.out.println("맵의 크기 :"+map.size());
		System.out.println(map.toString());
		
		// 맵은 같은 key를 저장했을 경우, key에 대한 value를 수정
		map.put(4, "신사임당");
		System.out.println(map.toString());
		
		// 값을 얻기 - 키를 주면 값을 반환
		String value= map.get(3);
		System.out.println("3번에 대한 값은: "+value);
		
		// 맵은 순서가 있지는 않기 때문에, 반복을 돌리려면 반복자를 활용
		
		// keySet -> key를 set으로 반환
		Set<Integer> keySet = map.keySet();
		
		for(Integer key :keySet) {
			System.out.println("키:"+key + ", 값:"+map.get(key));
		}
		System.out.println("-".repeat(30));
		
		// EntrySet -> key와 value를 통쨰로 꺼내줌
		Set<Entry<Integer, String>> entrySet= map.entrySet();
		
		// 엔트리 안에는 key, value를 얻는 함수 getKey(),getValue()가 있음
		for(Entry<Integer,String> e:entrySet) {
			System.out.println("키:"+e.getKey()+", 값:"+e.getValue());
		}
		
		// map에 있는 key의 유무 확인
		if(map.containsKey(1)) {
			System.out.println("1번 키는 이미 존재 함");
		}
		
		//map의 삭제
		map.remove(1);
		System.out.println(map.toString());
		
	}
}
