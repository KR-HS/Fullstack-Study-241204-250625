package quiz01;
import java.util.Scanner;

public class Quiz08 {
	public static void main(String args[]) {
		String[] arr = {"안녕하세요","hello","니하오","#@#@"};
		Scanner sc = new Scanner(System.in);
		/*
		 * 랜덤한 배열의 요소를 선택하고 이 랜덤한 배열요소에 따른 국가별 언어를 출력.
		 */
		System.out.print("선택된단어[안녕하세요,hello,니하오,#@#@]:");
		String str= sc.next();
		
		int num=0;
		for(int i=0;i<arr.length;i++) {
			if(str.equals(arr[i])) {
				num=i;
				break;
			}
		}

		switch(num){
			case 0:
				System.out.println("한국어 입니다.");
				break;
			case 1:
				System.out.println("영어 입니다.");
				break;
			case 2:
				System.out.println("중국어 입니다.");
				break;
			case 3:
				System.out.println("특문 입니다.");
				break;
			default:
				System.out.println("알수없는 언어 입니다.");
				break;
			
		}
		
		
		int ran = (int)(Math.random()*arr.length);
		System.out.println("선택된단어:"+arr[ran]);
		switch(ran){
		case 0:
			System.out.println("한국어 입니다.");
			break;
		case 1:
			System.out.println("영어 입니다.");
			break;
		case 2:
			System.out.println("중국어 입니다.");
			break;
		case 3:
			System.out.println("특문 입니다.");
			break;
		default:
			System.out.println("알수없는 언어 입니다.");
			break;
		
	}
		sc.close();
	
	}

}
