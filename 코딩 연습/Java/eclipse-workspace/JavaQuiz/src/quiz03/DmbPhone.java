package quiz03;

//DmbPhone은 Phone클래스를 상속 받습니다.
public class DmbPhone  extends Phone{
	//channel 변수를 생성하고, color, model, channel을 초기화 하는 생성자를 작성하세요.
	int channel;
	
	DmbPhone(){
		color="레드";
		model="모토로라";
		channel=10;
	}
	DmbPhone(String mo, String co, int ch){
		color=co;
		model=mo;
		channel=ch;
	}
	
	//메인메서드가 정상적으로 실행되도록 메서드를 추가하세요.
	void turnOnDmb() {
		System.out.println("TV를 켭니다");
	}
	int changeChannel(int ch) {
		System.out.println("채널을 "+ch+"로 변경했습니다.");
		return channel=ch;
	};
	void turnOffDmb() {
		System.out.println("TV를 끕니다");
	}; //기능: TV를 끕니다 출력
}
