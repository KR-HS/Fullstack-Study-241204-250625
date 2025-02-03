package ramda.stream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
public class MainClass01 {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동","이순신","홍길자","신사임당");
		
		for(String s:list) {
			System.out.println(s);
		}
		
		System.out.println("-".repeat(30));
		// 람다스트림 사용 시
		Stream<String> stream = list.stream();
		// 익명자 사용
		//stream.forEach(new Consumer<String>() {
		// 
		// 	@Override
		//	public void accept(String t) {
		//		System.out.println(t);
		//	}
		//});
		stream.forEach(s->System.out.println(s));
	}
}
