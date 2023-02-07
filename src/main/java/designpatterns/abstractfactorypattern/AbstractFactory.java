package designpatterns.abstractfactorypattern;

public abstract class AbstractFactory {
	abstract IAnimal getAnimalSound(String sound);
	abstract ISwitchTheme getTheme(String theme);
}
