package PR;
import java.io.*;
import java.util.*;
public class Main2 {
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> number = new LinkedList<>();
		Deque<Integer> value = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		
		for(int i=1;i<=n;i++) {
			number.offer(i);
			value.offer(Integer.parseInt(str[i-1]));
		}
		
		bw.write(number.pollFirst()+" ");
		int count=value.pollFirst();
		
		while(number.size()>1) {
			
			while(count!=0) {
				if(count<0) {
					count++;
					if(count==0) {
						bw.write(number.pollLast()+" ");
						count=value.pollLast();
						break;
					}
					number.offerFirst(number.pollLast());
					value.offerFirst(value.pollLast());
				}
				else {
					count--;
					if(count==0) {
						bw.write(number.pollFirst()+" ");
						count=value.pollFirst();
						break;
					}
					number.offerLast(number.pollFirst());
					value.offerLast(value.pollFirst());
				}
			}
		}
		if(!number.isEmpty()) {
			bw.write(number.poll()+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
		
		
		
	}
}