package quiz01;
import java.util.*;

public class Quiz24 {
	public static void main(String args[]){
		//https://www.acmicpc.net/problem/9086
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        
        for(int i=0;i<t;i++){
            String input= sc.next();
            System.out.println(""+input.charAt(0)+input.charAt(input.length()-1));
        }
		
        //https://www.acmicpc.net/problem/11720
        
        int n = sc.nextInt();
        sc.nextLine();
        String word = sc.nextLine();
        String[] str= word.split("");
        int sum=0;
        for(String s:str){
            sum+=Integer.parseInt(s);
        }
        System.out.println(sum);
        
//        sum=0;
//        for(int i=0;i<word.length();i++) {
//        	sum+=(int)(word.charAt(i)-'0');
//        }
//        System.out.println(sum);
        
	}
}
