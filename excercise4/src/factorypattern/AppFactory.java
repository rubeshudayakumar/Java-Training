package factorypattern;

import java.util.HashMap;

public class AppFactory {
	
	private static HashMap<String, App> apps = new HashMap<String, App>();
	
	public static void addApp(String name,App app) {
		apps.put(name, app);
	}
	
	public static App getApp(String appname) {
		return (apps.get(appname)).createApp();
	}

}
