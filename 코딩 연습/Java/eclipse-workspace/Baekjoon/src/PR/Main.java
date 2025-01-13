package PR;
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		String[] str = br.readLine().split(" ");
		int[] arr = new int[c];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}

		List<Integer> student = new LinkedList<Integer>();
		List<Integer> count = new LinkedList<Integer>();

		for(int a: arr){
			if(student.contains(a)){
				count.set(student.indexOf(a),count.get(student.indexOf(a))+1);
				continue;
			}
			else {
				if(student.size()<n){
					student.add(a);
					count.add(1);
				}
				
				else{
					student.remove(student.get(count.indexOf(Collections.min(count))));
					count.remove(Collections.min(count));
					student.add(a);
					count.add(1);
				}
			}
		}
		
		student.sort(null);
		for(int s : student){
			bw.write(s+" ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
		



	}
}