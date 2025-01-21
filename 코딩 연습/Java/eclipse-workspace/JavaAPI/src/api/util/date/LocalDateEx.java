package api.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class LocalDateEx {
	public static void main(String args[]) {
		/*
		 * LocalDate 클래스 - 년 월 일 
		 * LocalTime 클래스 - 시 분 초
		 * LocalDateTime클래스 - 년 월 일 시 분 초
		 */
		LocalDate nDate = LocalDate.now();
		System.out.println(nDate);
		LocalDate ofDate = LocalDate.of(2022, 2,12);
		System.out.println(ofDate);
		
		LocalTime nTime = LocalTime.now();
		System.out.println(nTime);
		
		LocalDateTime nDateTime = LocalDateTime.now();
		System.out.println(nDateTime);
		LocalDateTime ofDateTime=LocalDateTime.of(nDate, nTime);
		System.out.println(ofDateTime);
		
		// 로컬데이트 타임을 문자형으로 포맷
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E요일) a hh시 mm분 ss초");
		String result2 = nDateTime.format(dtf);
		System.out.println(result2);
	}
}
