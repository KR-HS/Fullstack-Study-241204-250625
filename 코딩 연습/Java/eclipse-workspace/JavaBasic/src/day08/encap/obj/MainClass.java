package day08.encap.obj;

public class MainClass {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		
		//setter
		Chef c = new Chef();
		hotel.setChef(c);
		
		//getter
		Chef chef = hotel.getChef();
		chef.cooking();
		
	}
}
