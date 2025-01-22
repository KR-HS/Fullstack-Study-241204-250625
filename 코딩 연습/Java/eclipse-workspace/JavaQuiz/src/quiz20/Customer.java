package quiz20;

public class Customer {
	
	private String name;
	private int arrivalTime; // 업무 처리 소요시간
	
	// 생성자
	public Customer() {
		
	}
	
	public Customer(String name,int arrivalTime) {
		this.name= name;
		this.arrivalTime=arrivalTime;
	}
	
	// setter
	public void setName(String name) {
		this.name= name;
	}
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime=arrivalTime;
	}
	// getter
	public String getName() {
		return name;
	}
	
	public int getArrivalTime(){
		return arrivalTime;
	}
}
