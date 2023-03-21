package factorypattern;

public class Youtube extends App{
	
	static {
		AppFactory.addApp("Youtube", new Youtube());
	}

	@Override
	public App createApp() {
		return new Youtube();
	}

	@Override
	public void useApp() {
		System.out.println("Using youtube app!");
	}
	
}
