package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
		
	}
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1=br.readLine();
		String s2=br.readLine();
		String s3=br.readLine();
		
		if(isNumeric(s1)) {
			if((Integer.parseInt(s1)+3)%15==0) bw.write("FizzBizz");
			else if ((Integer.parseInt(s1)+3)%5==0) bw.write("Buzz");
			else if((Integer.parseInt(s1)+3)%3==0) bw.write("Fizz");
			else bw.write(Integer.parseInt(s1)+3+"");
			bw.write("\n");
			bw.flush();
			return;
		}else {
			if(isNumeric(s2)) {
				if((Integer.parseInt(s2)+2)%15==0) bw.write("FizzBizz");
				else if ((Integer.parseInt(s2)+2)%5==0) bw.write("Buzz");
				else if((Integer.parseInt(s2)+2)%3==0) bw.write("Fizz");
				else bw.write(Integer.parseInt(s1)+2+"");
				bw.write("\n");
				bw.flush();
				return;
			}else{
				if(isNumeric(s3)) {
				if((Integer.parseInt(s3)+1)%15==0) bw.write("FizzBizz");
				else if ((Integer.parseInt(s3)+1)%5==0) bw.write("Buzz");
				else if((Integer.parseInt(s3)+1)%3==0) bw.write("Fizz");
				else bw.write(Integer.parseInt(s1)+1+"");
				bw.write("\n");
				bw.flush();
				return;
				}
			}
		}
		
//		else {
//			if(s1.equals("FizzBuzz")) 
//				bw.write("Fizz");
//			
//			else if(s1.equals("Fizz")) {
//				if(s2.equals("Buzz")) 
//					bw.write("Fizz");
//				else {
//					bw.write("Fizz");
//				}
//			}else if(s1.equals("Buzz")) {
//				bw.write("error"); // 어떤 문자열이 올지 모름
//			}else {
//				if(s2.equals("FizzBuzz")) bw.write("error"); // 어던 문자열이 올지 모름
//				else if(s2.equals("Fizz")) {
//					bw.write("error");
//				}
//			}
//		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();	
	}
}


