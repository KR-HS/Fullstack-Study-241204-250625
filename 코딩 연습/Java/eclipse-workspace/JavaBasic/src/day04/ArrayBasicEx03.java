package day04;

public class ArrayBasicEx03 {
	public static void main(String args[]) {
		int[] arr = {34,65,12,44,56,100,54,87,23,55};
		int max=arr[0];

		for(int a:arr) {
			if(max<a) max=a;
		}
		System.out.println(max);
		System.out.println();
	}
}
