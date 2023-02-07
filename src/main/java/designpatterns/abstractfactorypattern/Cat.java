package designpatterns.abstractfactorypattern;

public class Cat implements IAnimal{
	@Override
	public String makeSound() {
		return "Meow";
	}
}
