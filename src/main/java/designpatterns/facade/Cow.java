package designpatterns.facade;

public class Cow implements IAnimal{

	@Override
	public void createAnimal() {
		System.out.println("Cow created");
	}

}
