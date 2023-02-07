package designpatterns.abstractfactorypattern;

public class Dog implements IAnimal{
	@Override
	public String makeSound() {
		return "Woof";
	}
}
