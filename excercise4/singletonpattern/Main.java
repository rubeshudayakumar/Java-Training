package singletonpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			Desktop desktopUser1 = Desktop.createDesktop();
			desktopUser1.openFileManager();
		});

		es.execute(() -> {
			Desktop desktopUser2 = Desktop.createDesktop();
			desktopUser2.openFileManager();
		});
	}
}
