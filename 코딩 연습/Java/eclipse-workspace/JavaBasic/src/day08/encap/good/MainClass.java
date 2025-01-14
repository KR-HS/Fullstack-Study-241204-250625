package day08.encap.good;

public class MainClass {
	public static void main(String args[]) {
		MyDate md = new MyDate();
		
		md.setYear(5000);
		md.setYear(2025);;
		
		md.setMonth(13);
		md.setMonth(12);
		
		md.setDay(111);
		md.setDay(20);
		
		md.setSsn("??");
		md.setSsn(null);
		md.setSsn("1234567");
		
		md.info();
	}
}
