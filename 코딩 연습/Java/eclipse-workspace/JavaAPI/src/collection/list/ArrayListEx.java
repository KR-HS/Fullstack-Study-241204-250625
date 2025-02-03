package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		
		//ArrayList<String> list = new ArrayList<>();
		List<String> list = new ArrayList<>();
		
		//list에 추가
		list.add("java");
		list.add("database");
		list.add("html");
		list.add("git");
		list.add("java");
		
		//list를 문자열로 한눈에 확인
		System.out.println( list.toString() );
		
		//list의 크기 확인
		System.out.println("리스트 크기:" + list.size() );
		
		//list의 중간에 값을 추가
		list.add(2, "css"); //2번째 인덱스, css추가
		System.out.println( list.toString());
		
		//list에서 값을 얻기 
		String element = list.get(3);
		System.out.println("3번째 인덱스의 값:" + element);
		
		//list에 값이 포함되어 있는지 확인하기 - 문자열, 숫자에만
		if(list.contains("database") ) {
			System.out.println("database가 포함되어 있음");
		} else {
			System.out.println("database가 없음");
		}
		
		//list에 값 삭제
		list.remove(0); //인덱스
		list.remove("git"); //값
		System.out.println( list.toString() );
		
		//list에 값 수정
		list.set(0, "데이터베이스"); //0번째를 수정
		System.out.println( list.toString() );
		
		System.out.println("----------------------------------------");
		
		
		//요소를 지정해서 리스트를 빨리생성
		List<String> newList = Arrays.asList("홍길동", "이순신", "홍길자");
		
		
		//제네릭 <?> - 뭐든지 다들어 갈 수 있음
		//제네릭 <? extends String> - String이나, String의 자식타입은 전달가능
		//제네릭 <? super String> - String의 형태를 가질수 있다면 전달가능
		list.addAll(newList); //컬렉션<스트링> 전달이 가능함 
		
		
		System.out.println(list.toString());
		
		//리스트 요스를 전부 삭제
		list.clear();
		System.out.println(list.toString());
		
		
		
		
		
		
		
		
		
		
		
	}
}
