package collection.list;
import java.util.*;
public class ArrayListEx {
	public static void main(String[] args) {
		
		//ArrayList<String> list = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("database");
		list.add("html");
		list.add("git");
		list.add("java");
		
		// list를 문자열로 한눈에 확인
		System.out.println(list.toString());
		
		// list의 크기 확인
		System.out.println("리스트 크기:"+list.size());
		
		// list 중간에 값 추가
		list.add(2,"css");
		System.out.println(list.toString());
		
		// list에서 값 얻기
		System.out.println(list.get(2));
		
		// list에 값이 포함되어 있는지 확인
		if(list.contains("database")) {
			System.out.println("database가 있음");
		}else {
			System.out.println("database가 없음");
		}
		
		// list에서 값 삭제
		list.remove(0); // 인덱스
		list.remove("git"); // 값
		System.out.println(list.toString());
		
		// list에 값 수정
		list.set(0,"데이터베이스"); // 0번째를 수정
		System.out.println(list.toString());
		
		System.out.println("-".repeat(30));
		
		// 제네릭<?> - 무엇이든 다 들어 갈 수 있음.
		// 제네릭<? extends String> - String이나, String의 자식타입은 전달가능
		// 제네릭<? super String> - String의 형태를 가질 수 있다면 전달 가능
		// 요소를 지정해서 리스트를 생성
		List<String> newList=Arrays.asList("홍길동","이순신","홍길자");
		
		list.addAll(newList); // 컬렉션<String> 전달 가능
		System.out.println(list.toString());
		
		list.clear();
		System.out.println(list.toString());
	}
}
