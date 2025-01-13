package quiz03;

public class MainClass {

	public static void main(String[] args) {
		
		//Dmb폰 객체 생성
		DmbPhone dp = new DmbPhone("햅틱", "메탈그레이", 10);

		//Phone클래스에서 상속받은 멤버 변수에 접근
		System.out.println("모델: " + dp.model);
		System.out.println("색상: " + dp.color);
		//DmbPhone에서 선언한 멤버 변수에 접근
		System.out.println("채널: " + dp.channel);

		//Phone에서 상속받은 메서드 호출
		dp.powerOn();
		dp.ring();
		dp.sendVoice("여보세요??");
		dp.recieveVoice("안녕하세요? XX보험입니다.");
		dp.hangUp();

		//DmbPhone에서 선언한 메서드 호출
		dp.turnOnDmb(); //기능: TV를 켭니다 출력
		dp.changeChannel(7); //기능: channel변수를 전달받은 변수로 변경후 출력
		dp.turnOffDmb(); //기능: TV를 끕니다 출력
		dp.powerOff();

	}

}
