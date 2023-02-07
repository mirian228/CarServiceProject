package designpatterns.factorypattern;

public class AnimalFactory {
	public IAnimal getAnimalSound(String sound) {
		if(sound == null) {
			return null;
		}
		if(sound.equalsIgnoreCase("Woof")) {
			return new Dog();
		} else if(sound.equalsIgnoreCase("Meow")) {
			return new Cat();
		} else if(sound.equalsIgnoreCase("Moo")) {
			return new Cow();
		}
		
		return null;
		
	}
	
}
