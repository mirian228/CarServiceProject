package designpatterns.abstractfactorypattern;


public class AnimalFactory extends AbstractFactory {
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

	@Override
	ISwitchTheme getTheme(String theme) {
		// TODO Auto-generated method stub
		return null;
	}
}
