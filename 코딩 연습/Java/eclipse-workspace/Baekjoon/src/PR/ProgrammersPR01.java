package PR;
import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/340198
public class ProgrammersPR01{
	 public static int solution(int[] mats, String[][] park) {
	        int row = park.length;
	        int col = park[0].length; 
	        
	        int max=0;
	        boolean isEmpty=true;
	        outerloop1:for(int m:mats){
	        	if(m==1) {
	        		for(String[] pa:park) {
	        			for(String p: pa) {
	        				if(p.equals("-1")) {
	        					if(max<m) max=m;
	        					continue outerloop1;
	        				}
	        			}
	        		}
	        	}
	            for(int i=0;i<=row-m;i++){
	                for(int j=0;j<=col-m;j++){
	                    isEmpty=true;
	                    int count=0;
	                    outerloop2:for(int k=0;k<m;k++){
	                        for(int l=0;l<m;l++){
	                            if(!park[i+k][j+l].equals("-1")){
	                                isEmpty=false;
	                                break outerloop2;
	                            }
	                            count++;
	                        }
	                    }
	                    if(isEmpty){
	                    	if(max<m)max=m;
	                        continue outerloop1;
	                    }
	                }
	            }
	        }
	        return max;
	    }
	public static void main(String args[]){
		int[] mats= {1,2};
		String[][] park =  {{"A","-1"},{"A","-1"}};
		System.out.println(solution(mats,park));
	}
}