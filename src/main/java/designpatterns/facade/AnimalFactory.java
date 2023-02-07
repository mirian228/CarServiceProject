package designpatterns.facade;

public class AnimalFactory {
	private IAnimal dog;
	private IAnimal cat;
	private IAnimal cow;
	
	public AnimalFactory() {
		dog = new Dog();
		cat = new Cat();
		cow = new Cow();
		
	}
	
	public void createDog() {
		dog.createAnimal();
	}

	public void createCat() {
		cat.createAnimal();
	}
	
	public void createCow() {
		cow.createAnimal();
	}
	
}
