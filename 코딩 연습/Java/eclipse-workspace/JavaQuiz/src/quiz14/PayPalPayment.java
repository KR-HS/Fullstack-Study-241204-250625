package quiz14;

public class PayPalPayment implements Payment{
	
	private String pin;
	
	PayPalPayment(String pin){
		this.pin=pin;
	}

	// setter
	public void setPin(String pin) {
		this.pin=pin;
	}
	// getter
	public String getPin() {
		return pin;
	}
	
	
	
	//pay 메서드는 "PayPal로 [금액]원을 결제합니다."를 출력합니다.
	@Override
	public void pay(int amount) {
		System.out.printf("PayPal로 [%d]원을 결제합니다.\n",amount);
	}
	
	// validatePaymentDetails 메서드는 
	// PIN 번호가 멤버변수 PIN 번호와 일치하는지 확인하여 결과를 반환합니다.
	@Override
	public boolean validatePaymentDetails(String details) {
		if(!details.equals(pin)) {
			System.out.println("핀번호가 일치하지 않습니다.");
			return false;
		}
		return true;
	}
}
