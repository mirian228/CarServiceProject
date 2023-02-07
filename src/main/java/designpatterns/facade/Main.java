package designpatterns.facade;

public class Main {

	public static void main(String[] args) {
		AnimalFactory animalFactory = new AnimalFactory();
		animalFactory.createDog();
		animalFactory.createCat();
		animalFactory.createCow();
		
	}

}
