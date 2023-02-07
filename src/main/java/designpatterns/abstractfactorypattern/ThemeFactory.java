package designpatterns.abstractfactorypattern;

public class ThemeFactory extends AbstractFactory {



	@Override
	ISwitchTheme getTheme(String theme) {
		if(theme == null) {
			return null;
		}
		if(theme.equalsIgnoreCase("Light theme")) {
			return new Morning();
		}else if(theme.equalsIgnoreCase("Dimmed Theme")) {
			return new Evening();
		}else if(theme.equalsIgnoreCase("Dark Theme")) {
			return new Night();
		}
		return null;
		
		
	}
	
	@Override
	IAnimal getAnimalSound(String sound) {
		// TODO Auto-generated method stub
		return null;
	}

}
