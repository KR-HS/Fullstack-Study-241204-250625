package PR;
import java.io.*;
public class PR2941 {
	//https://www.acmicpc.net/problem/2941
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input= br.readLine(); //입력
		
		// 크로아 문자 변환 배열
		String[] croa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		int count=0; // 문자개수 카운팅 변수
		String remain=input; // 크로아 문자 치환 후 저장할 변수 (입력받은 변수로 써도됨)
		int len; // 변환 전 문자 길이 저장할 변수
		
		// 크로아 문자 카운팅
		for(String cr: croa) {
			len=remain.replace("0","").length(); // 크로아 문자 치환 전 길이 초기화
			remain=remain.replace(cr, "0");  // 크로아 문자를 0으로 치환
			count+=(len-remain.replace("0","").length())/cr.length();  // 문자 치환전 길이에서 치환 후 길이를 뺀값을 크로아문자의 길이로 나누어 문자 개수를 세고 count 변수에 sum.  
			if(remain.replace("0","").length()==0) break; // 치환 후 문자열이 모두 0이면 종료.
		}
		
		count+=remain.replace("0","").length(); // 0이외의 문자가 남아있다면 그 길이만큼 count변수에 sum.
		bw.write(count+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
