package designpatterns.abstractfactorypattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		AbstractFactory animalFactory = FactoryGenerator.getFactory("IAnimal");
		
		IAnimal firstAnimal = animalFactory.getAnimalSound("woof");
		LOGGER.info("First animal does: " + firstAnimal.makeSound());
		
		IAnimal secondAnimal = animalFactory.getAnimalSound("meow");
		LOGGER.info("Second animal does: " + secondAnimal.makeSound());
		
		IAnimal thirdAnimal = animalFactory.getAnimalSound("Moo");
		LOGGER.info("Third animal does: " + thirdAnimal.makeSound());
		
		
		AbstractFactory themeFactory = FactoryGenerator.getFactory("ISwitchTheme");
		
		ISwitchTheme firstTheme = themeFactory.getTheme("Light theme");
		LOGGER.info("Morning theme is: " + firstTheme.changeTheme());
		
		ISwitchTheme secondTheme = themeFactory.getTheme("Dimmed Theme");
		LOGGER.info("Morning theme is: " + secondTheme.changeTheme());
		
		ISwitchTheme thirdTheme = themeFactory.getTheme("Dark Theme");
		LOGGER.info("Morning theme is: " + thirdTheme.changeTheme());
		
	}

}
