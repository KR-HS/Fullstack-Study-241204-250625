package api.util.date;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateEx {
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		// SimpleDateFormat - 날짜형 -> 문자형 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E요일) a hh시 mm분 ss초");
		String result= sdf.format(date);
		System.out.println(result);
	}
}
