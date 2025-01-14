package quiz07;

public class Car {
	
	String model;
	int speed;
	
	//1. model과 speed 전달받아서 저장하는 생성자를 만드세요.
	Car(String model, int speed){
		this.model=model;
		this.speed = speed;
	}
	//2. model만 전달받아서 model에 저장하는 생성자를 생성하세요
	Car(String model){
		this(model,0);
		
	}
	//3. 생성자를 하나로 연결하세요

	void accel(int speed) {
		/*
		멤버변수 speed가 150 이상이라면 "속도를 올릴 수 없습니다" 를 출력
		그렇지 않으면 매개변수를 멤버변수에 저장하세요
		*/
		if(this.speed>=150) {
			System.out.println("속도를 올릴 수 없습니다.");
			return;
		}
		this.speed=speed;
		// this.speed+=speed;
	}
	
	void run() {
		/*	
		0-200 까지 30씩 증가하는 for문을 생성하고, 
		for문안에서 accel()를 호출하세요
		멤버변수 speed도 출력하세요
		*/
		
		for(int i=0;i<=200;i+=30) {
			accel(this.speed+i);
			
			if(this.speed>=150) {
				accel(this.speed);
				break;
			}
			
			System.out.println(this.speed);
		}
	}
}







