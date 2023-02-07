package designpatterns.facade;

public class Cat implements IAnimal {

	@Override
	public void createAnimal() {
		System.out.println("Cat created");
	}

}
