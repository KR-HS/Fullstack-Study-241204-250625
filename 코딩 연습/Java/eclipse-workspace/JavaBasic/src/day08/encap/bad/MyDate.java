package day08.encap.bad;

public class MyDate {
	// 나의 정보를 저장하는 클래스
	public int year;
	public int month;
	public int day;
	public String ssn;  // 주민번호
	
	
	public void info() {
		System.out.println("생일:"+year+"-"+month+"-"+day);
		System.out.println("주민번호 :"+ssn);
	}
}
