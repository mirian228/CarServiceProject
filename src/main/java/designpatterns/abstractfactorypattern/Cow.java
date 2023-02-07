package designpatterns.abstractfactorypattern;

public class Cow implements IAnimal{
	@Override
	public String makeSound() {
		return "Moo";
	}
}
