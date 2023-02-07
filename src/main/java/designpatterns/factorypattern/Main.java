package designpatterns.factorypattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		AnimalFactory animalFactory = new AnimalFactory();
		
		IAnimal firstAnimal = animalFactory.getAnimalSound("woof");
		LOGGER.info("First animal does: " + firstAnimal.makeSound());
		
		IAnimal secondAnimal = animalFactory.getAnimalSound("meow");
		LOGGER.info("Second animal does: " + secondAnimal.makeSound());
		
		IAnimal thirdAnimal = animalFactory.getAnimalSound("Moo");
		LOGGER.info("Third animal does: " + thirdAnimal.makeSound());
		
	}

}
