package factorypattern;

public class Main {
	
	
	static {
		try {
			Class.forName("factorypattern.Instagram");
			Class.forName("factorypattern.Whatsapp");
			Class.forName("factorypattern.Youtube");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		App instagram = AppFactory.getApp("Instagram");
		instagram.useApp();
		
		App whatsapp = AppFactory.getApp("Whatsapp");
		whatsapp.useApp();
		
		App youtube = AppFactory.getApp("Youtube");
		youtube.useApp();
		
	}
}
