package day03;

public class WhileEx02 {
	public static void main(String args[]) {
		// 1~50까지의 수 중에서 짝수들의 합계
		int i=1;
		int sum=0;
		while(i<=50) {
			if(i%2==0) {
				sum+=i;
			}
			i++;
		}
		System.out.println(sum);
		System.out.println("--------------------");
		int i1=2;
		int sum1=0;
		while(i1<=50) {
			sum1+=i1;
			i1+=2;
		}
		System.out.println(sum1);
	}
}
