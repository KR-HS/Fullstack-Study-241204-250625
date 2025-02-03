package api.util.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		
		//랜덤 난수를 다양한 방식으로 제공
		Random random = new Random();
		
		double d = random.nextDouble();
		System.out.println("0~1미만 랜덤수:" + d);
		
		int a = random.nextInt();
		System.out.println("int범위의 랜덤수:" + a);
		
		int b = random.nextInt(10); 
		System.out.println("0~10미만 랜덤수:" + b);
		
		
		
	}
}
