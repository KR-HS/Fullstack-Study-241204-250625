package quiz18;
import java.util.*;
public class MainClass {
	
	public static void main(String[] args) {
		/*
		 * 띄어쓰기 기준으로 데이터 입력이 들어올 때,
		 * 정수배열에 저장하기
		 * 5
		 * 54 32 43 52 75
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.nextLine().split(" ");
		int[] arr = new int[str.length];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
