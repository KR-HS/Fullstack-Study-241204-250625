package quiz17;
import java.util.*;
import java.lang.*;
public class StringQuiz03 {

	public static boolean palindrom1(String word) {
		for(int i=0;i<word.length()/2;i++) {
			if(word.charAt(i)!=word.charAt(word.length()-1-i)) return false;
		}
		return true;
	}
	public static boolean palindrom2(String word) {
		StringBuilder sb = new StringBuilder(word);
		if(sb.length()%2==0) {
			if( sb.substring(0,word.length()/2).
					compareTo(new StringBuilder(sb.substring(sb.length()/2,sb.length())).reverse().toString())!=0 )
				return false;
		}else {
			if( sb.substring(0,word.length()/2).
					compareTo(new StringBuilder(sb.substring(sb.length()/2+1,sb.length())).reverse().toString())!=0 )
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		/*
		 * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 함수를 작성하시오.

			팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 

			level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

			boolean palindrom(String word) : 팰린드롬이면 true, 아니면 false을 반환한다..
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("문자입력:");
		String s = sc.nextLine();
		System.out.println(s+"는 팰린드롬?>>"+palindrom1(s));
		System.out.println(s+"는 팰린드롬?>>"+palindrom2(s));
	}
}
