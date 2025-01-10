package quiz02;

public class TV {
	
	  /*
		멤버변수
		회사명 - String
		채널번호 - int
		전원 - boolean
		
		생성자
		기본 생성자는 회사명을 초기화 LG
		
		메서드
		정보출력 - info() : 반환 void - 티비의 정보를 출력
		채널변경 - changeChannel(int) : 반환 int - 현재 채널을, 전달받은 값으로 변경하는 기능
		전원켜기 - power() : 반환 void - 전원을 껐다 켰다 하는기능
		
		*/
	String company;
	int channel;
	boolean onOff;
	
	TV(){
		company="LG";
	}
	
	TV(String company){
		this.company=company;
	}
	public void info() {
		System.out.print("TV 제조사 :"+company+", 채널:"+channel+", 전원 on/off 여부:");
		System.out.println(onOff?"ON":"OFF");
		System.out.println("-----------------------");
	}
	
	public int changeChannel(int channel) {
		if(!onOff) {
			System.out.println("TV전원을 켜주세요.");
			return 0;
		}
		System.out.println(this.channel+"에서 "+channel+"으로 채널 변경");
		System.out.println("-----------------------");
		this.channel=channel;
		return this.channel;
	}
	public void power() {
		System.out.println(onOff?"TV의 전원을 껐습니다.":"TV의 전원을 켰습니다.");
		System.out.println("-----------------------");
		onOff=onOff?false:true;
	}
}
