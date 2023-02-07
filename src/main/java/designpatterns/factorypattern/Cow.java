package designpatterns.factorypattern;

public class Cow implements IAnimal {

	@Override
	public String makeSound() {
		return "Moo";
	}

}
