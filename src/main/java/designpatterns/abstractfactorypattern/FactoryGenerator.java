package designpatterns.abstractfactorypattern;

public class FactoryGenerator {
	 public static AbstractFactory getFactory(String choice){		   
	      if(choice.equalsIgnoreCase("IAnimal")){
	         return new AnimalFactory();
	 
	      }else if(choice.equalsIgnoreCase("ISwitchTheme")){
	         return new ThemeFactory();
	      }
	 
	      return null;
	   }
}
