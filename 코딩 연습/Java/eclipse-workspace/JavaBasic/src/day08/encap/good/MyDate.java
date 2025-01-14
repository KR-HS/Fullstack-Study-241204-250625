package day08.encap.good;

public class MyDate {
	// 나의 정보를 저장하는 클래스
	private int year;
	private int month;
	private int day;
	private String ssn;  // 주민번호
	
	/*
	 * 은닉(가려진) 변수에 접근할 때, 미리 생성해 놓은 getter/setter메서드를 사용
	 * 
	 * setter메서드 선언
	 * 1. 은닉 변수에 값을 저장하기 위한 메서드
	 * 2. 접근 제어자를 public으로 선언하고 이름 (set+멤버변수명) 으로 만듬
	 * 
	 */
	
	public void setYear(int year) {
		// 유효성 검증 내용을 추가할 수 있음
		if(year<1950||year>2025) {
			System.out.println("잘못된 값 입력 입니다");
			return;
		}
		this.year = year;
	}
	/*
	 * getter메서드 선언
	 * 1. 은닉 변수에 값을 조회하기 위한 메서드
	 * 2. 접근제어자 public으로 선언하고 이름 (get+멤버변수명) 으로 만듬
	 */
	public int getYear() {
		// 유효성 검사를 할 수도 있음
		return year;
	}
	/*
	 * month,day,ssn에 대한 getter, setter를 생성
	 * 
	 * month- 1~12월까지만 저장
	 * day - 1~31일 까지만 저장
	 * ssn - 문자열 13자리 까지만 저장
	 * 
	 */
	
	// month
	public void setMonth(int month) {
		if(month<1||month>12) {
			System.out.println("입력 오류");
			return;
		}
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}

	// day
	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		if(day<1||day>31) {
			System.out.println("입력 오류");
			return;
		}
		this.day = day;
	}

	// ssn
	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		if(ssn==null) {
			System.out.println("입력오류");
			return;
		}
		if(ssn.length()<1||ssn.length()>13) {
			System.out.println("입력 오류");
			return;
		}
		for(char c:ssn.toCharArray()) {
			if(!(c>='0'&&c<='9')) {
				System.out.println("문자 입력 오류");
				return;
			}
		}
		this.ssn = ssn;
	}


	public void info() {
		System.out.println("생일:"+year+"-"+month+"-"+day);
		System.out.println("주민번호 :"+ssn);
	}
}
