package factorypattern;

public class Instagram extends App{
	
	static {
		AppFactory.addApp("Instagram", new Instagram());
	}
	

	@Override
	public App createApp() {
		return new Instagram();
	}

	@Override
	public void useApp() {
		System.out.println("Using instagram app!");
	}

}
