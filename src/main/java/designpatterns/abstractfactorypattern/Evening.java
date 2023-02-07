package designpatterns.abstractfactorypattern;

public class Evening implements ISwitchTheme {

	@Override
	public String changeTheme() {
		return "Dimmed Theme";
		
	}

}
