package PR;
import java.util.*;


public class PR3052 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		boolean[] arr = new boolean[42];
		for(int i=0;i<10;i++) {
			arr[(sc.nextInt()%42)]=true;
		}
		for(boolean bool: arr) {
			if(bool) {
				count++;
			}
		}
		System.out.println(count);
	}
}
