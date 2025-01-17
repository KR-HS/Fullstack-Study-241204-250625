package quiz14;

public interface Payment {
	
	// 특정금액지불
	void pay(int amount);
	// 지불 세부사항이 유효한지 확인
	boolean validatePaymentDetails(String details);
}
