package day11.exception.trycatch;

public class MultiCatchEx01 {
	public static void main(String[] args) {
		//main에 값을 주는 방법
		
		// run탭 > run configuration > arguments탭 > ${string_prompt}
		try {
		String a =args[0];
		String b = args[1];
		
		int x = Integer.parseInt(a);
		int y= Integer.parseInt(b);
		System.out.println(x+y);
		
		String str =null; // 기타 예외....
		str.charAt(0);
		
		}// 예외의 종류별로, 다른 프로그램 처리를 할 수 있습니다.
		catch(ArrayIndexOutOfBoundsException | ClassCastException e) { //여러 예외에 대해 동일한 처리를 할때 "|" 를 이용
			System.out.println("실행 매개값을 반드시 2개 전달해 주세요");
			System.out.println(e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("실행 매개값을 반드시 숫자를 전달해 주세요");
			System.out.println(e.getMessage());
		}catch(Exception e) { // 예외의 부모 클래스이기 때문에, 모든 예외 처리 가능
			System.out.println("기타 예외 입니다.");
			System.out.println(e.getMessage());
		}
		
		
	}
}
