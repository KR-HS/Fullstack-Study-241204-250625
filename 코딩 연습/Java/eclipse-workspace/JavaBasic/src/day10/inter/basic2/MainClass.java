package day10.inter.basic2;

public class MainClass {
	public static void main(String[] args) {
		
		Animal baduk = new Dog();
		Animal navi = new Cat();
		Animal hodol = new Tiger();
		
		Animal[] arr = {baduk,navi,hodol};
		
		for(Animal a:arr) {
			a.eat(); // animal처럼 동작됨
		}
		
		//펫 타입
		IPet[] arr2 = new IPet[3];
		arr2[0]=(IPet)baduk; // 바둑이는 Animal타입이지만, IPet을 구현하고 있어서 상호 형변환이 가능
		arr2[1]=(IPet)navi;
		arr2[2]=new GoldFish();
		
		for(IPet pet:arr2) {
			pet.play(); // 펫처럼 사용
		}

		PetHouse.carePet((IPet)baduk);
		PetHouse.carePet(new GoldFish());
	}
}
