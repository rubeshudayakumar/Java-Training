package singletonpattern;

public class Desktop {
	public static Desktop desktop = null;
	
	private Desktop() {
		System.out.println("Welcome! Desktop has initialized!");
	}
	
	public void openFileManager() {
		System.out.println("File manager opened!");
	}
	
	synchronized public static Desktop createDesktop() {
		if(desktop == null) {
			desktop = new Desktop();
			return desktop;
		}
		System.out.println("Desktop is already initialized! returning the previous instance");
		return desktop;
	}
}
