package day10.inter.basic3;

	public class Samsung implements Printed{
	
		@Override
	public void print(String document) {
			System.out.println("from 상성");
			System.out.println(document+"출력됨");
	}
	@Override
	public int copy(int n) {
		System.out.println("from 상성");
		for(int i=1;i<=n;i++) {
			System.out.println(i+"장 복사");
		}
		return n;
	}
	
}
