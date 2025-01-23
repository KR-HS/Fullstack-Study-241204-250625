package collection.map;
import java.util.*;

public class TreeMapEx {
	public static void main(String[] args) {
		// 사용방법 hashmap과 동일
		Map<Integer,String> map = new TreeMap<>();
		
		map.put(2, "a");
		map.put(3, "b");
		map.put(5, "c");
		map.put(1, "밥먹자");
		
		System.out.println(map.toString());
	}
}
