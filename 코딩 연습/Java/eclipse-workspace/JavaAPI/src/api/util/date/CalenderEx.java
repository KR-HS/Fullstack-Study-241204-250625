package api.util.date;

import java.util.Calendar;

public class CalenderEx {
	public static void main(String args[]) {
		
		// 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초\n",year,month,day,hour,minute,second);
	}
}
