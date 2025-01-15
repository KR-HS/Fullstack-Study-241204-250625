package day08.encap.obj;

public class Hotel {
	
	//String name;
	private Chef chef;
	private Employee emp;
	
	//호텔이 생성될 떄, chef객체를 같이 만든다.
	public Hotel() {
		this.chef = new Chef();
		this.emp= new Employee();
	}
	
	// chef변수에 getter, setter
	
	//setter
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void setEmp(Employee emp) {
		this.emp=emp;
	}
	
	//getter
	public Chef getChef() {
		return chef;
	}
	public Employee getEmp() {
		return emp;
	}
}
