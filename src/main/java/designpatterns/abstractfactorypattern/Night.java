package designpatterns.abstractfactorypattern;

public class Night implements ISwitchTheme{

	@Override
	public String changeTheme() {
		return "Dark Theme";
	}

}
