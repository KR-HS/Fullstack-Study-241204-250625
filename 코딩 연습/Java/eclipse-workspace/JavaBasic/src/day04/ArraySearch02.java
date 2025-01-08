package day04;
import java.util.*;

public class ArraySearch02 {
	public static void main(String args[]) {
		
		// 1~ 100까지 정렬되어 있는 숫자가 있을때, 75를 찾는다.
		// 이진탐색 - 반을 분할해서 찾아가는 방법
		// 조건 - 반드시 값이 순서대로 정렬
		Scanner sc= new Scanner(System.in);
		int[] arr = {1,3,5,10,20,30,50,80,100};
		int find=sc.nextInt();

		int left=0;
		int right=arr.length-1;
		
		
		while(left<=right) {
			int mid=(right+left)/2;
			if(arr[mid]<find) {
				left=mid+1;
			}
			else if(arr[mid]>find){
				right=mid-1;
			}
			else {
				System.out.println("찾는 값은:"+mid+"번쨰에 있습니다.");
				break;
			}
		}
		
		// 찾은 위치를 알려줌, 찾을값이 없다면 음수 반환
		System.out.println(Arrays.binarySearch(arr,find)+"번째에 있습니다.");
		sc.close();
	}
	
}
