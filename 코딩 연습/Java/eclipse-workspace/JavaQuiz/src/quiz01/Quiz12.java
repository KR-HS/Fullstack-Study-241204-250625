package quiz01;
import java.util.*;
import java.io.*;

public class Quiz12 {
	public static void main(String args[]) {
		int[] arr= {1000,500,100,50,10};
		int money=17780;
		
		for(int ar: arr) {			
			System.out.println(ar+"원:"+money/ar);
			money%=ar;
		}
		
		int i=0;
		money=17780;
		while(i<arr.length) {
			System.out.println(arr[i]+"원:"+money/arr[i]);
			money%=arr[i];
			i++;
		}
	}
}
