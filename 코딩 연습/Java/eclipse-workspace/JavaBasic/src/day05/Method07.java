package day05;
import java.util.*;
public class Method07 {
	public static void main(String[] args) {
		// call by value vs call by reference
		int a =1;
		value(a); // 기본타입 변수는 값을 복사해서 전달
		System.out.println(a);//1
		
		System.out.println("-----------------------");
		int[] arr = new int[] {1,2,3,4,5}; 
		reference(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void value(int a) {
		a=100;
	}
	
	
	static void reference(int[] x) {
		x[0]=100;
		x[1]=900;
		x[2]=800;
	}
}
