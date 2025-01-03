package quiz01;
import java.util.*;

public class Quiz13 {
	public static void main(String args[]) {
		// 1. 7~100 사이의 정수들 중 7의 배수를 *가로로 출력
			System.out.println("7~100 사이의 정수들 중 7의 배수");
			int count=0;
			int sum=0;
			for(int i=7;i<=100;i+=7) {
				System.out.print(i+" ");
			}
			System.out.println();// 줄바꿈
			
		//2. 200 까지 정수중에서 8의 배수의 개수를 출력
			for(int i=8;i<=200;i+=8) {
				count++;
			}
			System.out.println("200 까지 정수중에서 8의 배수의 개수:"+count);
			
			
		//3 . 50~100 사이의 짝수의 합
			for(int i=50;i<=100;i++) {
				if(i%2==0) {
					sum+=i;
				}
			}
			System.out.println(" 50~100 사이의 짝수의 합: "+sum);
		// 4. A~Z까지 문자열의 합을 구하세요.
			sum=0;
			for(char a='A';a<='Z';a++) {
				sum+=a;
			}
			System.out.println("A~Z까지 문자열의 합 : "+sum);
			String str="";
			for (char a ='A';a<='Z';a++){
					str+=a;
			}
			System.out.println("A~Z까지 문자열의 합 : "+str);
	}
}
