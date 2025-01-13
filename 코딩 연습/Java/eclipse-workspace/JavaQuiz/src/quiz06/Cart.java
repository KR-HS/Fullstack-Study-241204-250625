package quiz06;

public class Cart {

	//부모클래스- 수정하지 마세요!!.
	String[] cart = new String[1];
	int money;
	int i = 0; //배열의 인덱스에 사용될 변수
	
	int tv; //상품의 가격
	int com;
	int radio;
	
	void buy(String product) {
		System.out.println("재정의 하세요");
	}
	
	void add(String product) {
		System.out.println("재정의 하세요");
	}
	
	void info() {
		System.out.println("재정의 하세요");
	}
	
}
