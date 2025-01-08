package quiz01;
import java.util.Scanner;
public class Quiz10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int count=0;
		//1. 1~입력받은 수 까지의 6의 배수의 합
		System.out.print("값 입력 > ");
		int num = sc.nextInt();
		int n=6;
		while(n<=num) {
			sum+=n;
			n+=6;
		}
		System.out.println("1~"+num+"까지의 6의 배수의 합 : "+sum);
		
		
		//2. 1~100까지 정수 중에서 4의 배수이면서, 8의 배수가 아닌 수의 개수
		count=0;
		int i=4;
		while(i<=100){
			count++;
			i+=8;
		}
		System.out.println("1~100까지 정수 중에서 4의 배수이면서, 8의 배수가 아닌 수의 개수: "+count);
		
		//3. 50~100까지 정수들의 합
		int j=50;
		sum=0;
		while(j<=100){
			sum+=j;
			j++;
		}
		System.out.println("50~100까지 정수들의 합 : "+sum);
		// 1000의 약수들의 개수
		int k=1;
		count=0;
		while(k<=Math.sqrt(1000)) {
			if(1000%k==0) {
				count++;
			}
			k++;
		}
		count*=2;
		System.out.println("1000의 약수들의 개수 : "+count);
		sc.close();
	}
}
