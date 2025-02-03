package quiz22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuiz02 {
	public static void main(String[] args) {
		//상품번호, GS25, (상품명), 가격 분리해서 출력.
		String str = "123123-45644 GS25(치킨도시락) 4,400원";
		String str2 = "123123-3453454 GS25(마늘햄쌈) 5,000원";
		String str3 = "123456-3453 GS(김혜자도시락) 6,000";
		String[] arr = {str, str2, str3};
		
		String number="\\d+-\\d+";
		String store="[a-zA-Z]+\\d*";
		String product="\\([가-힣]+\\)";
		String price="\\d+(,\\d+)+원?";
		
		Pattern number_p=Pattern.compile(number);
		Pattern store_p=Pattern.compile(store);
		Pattern product_p=Pattern.compile(product);
		Pattern price_p=Pattern.compile(price);
		
		for(String ar:arr) {
			Matcher number_m = number_p.matcher(ar);
			Matcher store_m = store_p.matcher(ar);
			Matcher product_m = product_p.matcher(ar);
			Matcher price_m = price_p.matcher(ar);
			
			while(number_m.find()&&store_m.find()
					&&product_m.find()&&price_m.find()) {
				System.out.println("상품번호:"+number_m.group());
				System.out.println("가게명:"+store_m.group());
				System.out.println("상품명:"+product_m.group());
				System.out.println("가격:"+price_m.group());
				System.out.println("-".repeat(30));
			}
			
		}
		
		
		
		
	}
}
