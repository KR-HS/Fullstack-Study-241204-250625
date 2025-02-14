package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
        int tc= Integer.parseInt(br.readLine());
        
        
        
        for(int i=0;i<tc;i++) {
        	// qu에 넣을 개수, 찾을 위치
        	String[] str = br.readLine().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int pos = Integer.parseInt(str[1]);
        	
        	
        	// qu에 넣을 데이터
        	String[] arr = br.readLine().split(" ");
        	
        	// 찾는 위치의 중요도
        	int target=Integer.parseInt(arr[pos]);

        	// 타겟보다 큰 개수
        	int count=0;

        	Queue<Integer> qu = new LinkedList<>();
        	for(String a: arr) {
        		qu.offer(Integer.parseInt(a));
        	}
        	
        	// 타겟의 위치 이하의 같은값 개수
        	int under = 0;
        	
        	// 타켓위치 바로 뒤의 큰값 뒤에 오는 타겟과 같은 수 카운팅
        	int upper = 0;
        	boolean isBig=false;

        	for(int j=0;j<n;j++) {
        		int poll= qu.poll();
        		if(j<=pos) {
        			if(poll==target) under++;
        			if(poll>target) count++;
        		}else {
        			if(poll>target) {
            			count++;
            			isBig=true;
            		}
                    if(poll==target&&isBig) upper++;
        			
        			
        		}
        	}
        	bw.write("count:"+count+",under:"+under+",upper:"+upper+"\n");

        	bw.write(count+under+upper+"\n");
        	
        }

        
		bw.flush();
		bw.close();
		br.close();	
	}
}


