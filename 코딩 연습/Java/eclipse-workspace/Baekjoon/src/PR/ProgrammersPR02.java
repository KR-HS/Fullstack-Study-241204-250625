package PR;
import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
public class ProgrammersPR02{
public static int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        // 오늘 날짜
        String[] today_date=today.split("\\.");
        int today_year=Integer.parseInt(today_date[0]);
        int today_month=Integer.parseInt(today_date[1]);
        int today_day=Integer.parseInt(today_date[2]);
        
        //계약 
        for(int count=1;count<=privacies.length;count++){
            String[] pr=privacies[count-1].split(" ");
            // 계약 종류
            String pr_var=pr[1];
            
            // 계약 당시 날짜
            String[] pr_date=pr[0].split("\\.");
            int pr_year=Integer.parseInt(pr_date[0]);
            int pr_month=Integer.parseInt(pr_date[1]);
            int pr_day=Integer.parseInt(pr_date[2]);
            
            // 계약 당시 날짜 + 계약 보관 기간
            for(String term:terms){
                String[] t=term.split(" ");
                if(pr_var.equals(t[0])){
                    pr_month+=Integer.parseInt(t[1]);
                    pr_day-=1;
                    if(pr_day==0){
                        pr_day=28;
                        pr_month-=1;
                    }
                    break;
                }
            }
            
            // month와 year 조정
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

            // 조건 비교
            if(today_year>pr_year){
                answer.add(count);
                continue;
            }
            if(today_year==pr_year){
                if(today_month>pr_month)
                {
                    answer.add(count);
                    continue;
                }
                if(today_month==pr_month){
                    if(today_day>pr_day){
                        answer.add(count);
                        continue;
                    }
                }
            }
        } // for문 종료
        
        // int[] 배열에 값 할당 후 리턴
        if (answer.size() == 0) {
            return new int[]{0};
        }
        
        int[] arr = new int[answer.size()];
        if (answer.size() > 0) {
            for (int i = 0; i < answer.size(); i++) {
                arr[i] = answer.get(i);
            }
        }
        
        return arr;
    }

	public static void main(String args[]){
		String today = "2022.05.19";
		String[] terms= {"A 6", "B 12", "C 3"};
		String[] privacies =  {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		System.out.println(Arrays.toString(solution(today,terms,privacies)));
	}
}