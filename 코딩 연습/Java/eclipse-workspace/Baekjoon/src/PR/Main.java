package PR;
import java.util.*;
public class Main {
	 public int[] solution(String today, String[] terms, String[] privacies) {
	        List<Integer> answer = new ArrayList<>();
	        // 오늘 날짜
	        String[] today_date=today.split(".");
	        int today_year=Integer.parseInt(today_date[0]);
	        int today_month=Integer.parseInt(today_date[1]);
	        int today_day=Integer.parseInt(today_date[2]);
	        
	        //계약 
	        int count=1;
	        for(String privacy:privacies){
	            String[] pr=privacy.split(" ");
	            // 계약 종류
	            String pr_var=pr[1];
	            
	            //계약당시 날짜
	            String[] pr_date=pr[0].split(".");
	            int pr_year=Integer.parseInt(pr_date[0]);
	            int pr_month=Integer.parseInt(pr_date[1]);
	            int pr_day=Integer.parseInt(pr_date[2]);
	            
	            for(String term:terms){
	                String[] t=term.split(" ");
	                if(pr_var.equals(t[0])){
	                    pr_month+=Integer.parseInt(t[1]);
	                    break;
	                }
	            }
	            if(pr_month>12){
	                if(pr_month%12==0){
	                    pr_year+=(pr_month/12-1);
	                    pr_month=12;
	                }
	                else{
	                    pr_year+=pr_month/12;
	                    pr_month%=12;
	                }
	            }
	            if(today_year<pr_year){
	                answer.add(count);
	            }
	            else if(today_year==pr_year){
	                if(today_month<pr_month)answer.add(count);
	                else if(today_month==pr_month){
	                    if(today_day<pr_day) answer.add(count);
	                }
	            }
	            count++;
	        }
	        int[] arr= new int[answer.size()];
	        for(int i=0;i<answer.size();i++) {
	        	arr[i]=answer.get(i);
	        }
	        return arr;
	    }
	 
	 public static void main(String args[]) {
		 String a="2025.12.01";
		 String[] b = a.split("\\.");
		 for(String c:b) {
			 System.out.println(c);
		 }
	 }
}
