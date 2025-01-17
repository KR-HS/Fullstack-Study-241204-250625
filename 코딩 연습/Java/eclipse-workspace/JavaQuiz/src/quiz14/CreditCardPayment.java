package quiz14;

public class CreditCardPayment implements Payment{
	// 특정 금액 지불
	// pay 메서드는 "신용카드로 [금액]원을 결제합니다."를 출력합니다.
	@Override
	public void pay(int amount) {
		System.out.printf("신용카드로 [%d]원을 결제합니다.\n",amount);
	}
	
	// 지불 세부사항 유효한지 확인
	// validatePaymentDetails 메서드는 
	// 카드 번호 형식(문자 16자리)이 올바른지 확인하여 결과를 반환합니다.
	@Override
	public boolean validatePaymentDetails(String details) {
		if(details.length()!=16) {
			System.out.println("입력 자리수 오류!!");
			return false;
		}
		
		for(char c:details.toCharArray()) {
			if(!(c>='0'&&c<='9')) {
				System.out.println("문자 형식 오류!!");
				return false;
			}
		}
		return true;
	}
}
