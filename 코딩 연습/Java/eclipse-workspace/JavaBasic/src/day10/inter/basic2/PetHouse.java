package day10.inter.basic2;

public class PetHouse {
	// 매개 변수로 펫 타입을 받아서, 매개변수에 따라서,형변환을 진행하는 메서드
	public static void carePet(IPet pet) {
		if(pet instanceof Dog) {
			Dog d=(Dog)pet;
			d.eat();
			d.play();
		} 
		if(pet instanceof Cat) {
			Cat cat=(Cat)pet;
			cat.eat();
			cat.play();
		}
		if(pet instanceof GoldFish) {
			GoldFish goldFish=(GoldFish)pet;
			goldFish.swim();
			goldFish.play();
		}
	};
}
