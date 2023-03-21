package factorypattern;

public class Whatsapp extends App {

	static {
		AppFactory.addApp("Whatsapp", new Whatsapp());
	}

	@Override
	public App createApp() {
		return new Whatsapp();
	}

	@Override
	public void useApp() {
		System.out.println("Using whatsapp!");
	}

}
