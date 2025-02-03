package collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {

		//중복 x, 자동으로 오름차순 정렬
		Set<String> set = new TreeSet<>();
		
		set.add("얼룩송아지");
		set.add("강아지");
		set.add("강아지");
		set.add("송아지");
		set.add("망아지");
		
		System.out.println(set.toString() );
		
		//나머지 사용방법은 HashSet과 동일함.
		
		
		
		
		
		
		
		
		
		
	}
}
