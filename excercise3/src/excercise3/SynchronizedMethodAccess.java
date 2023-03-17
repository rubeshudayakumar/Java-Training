package excercise3;

public class SynchronizedMethodAccess {
	
	synchronized public static void displayMessage(String message) throws InterruptedException {
		System.out.println("[------ "+message+"------]");	
		
		Thread.sleep(1000);
	}
	
	public static void main(String[] args) throws Exception {
		
		new Thread(() -> {
			try {
				displayMessage("Message from thread 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(() -> {
			try {
				displayMessage("Message from thread 2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(() -> {
			try {
				displayMessage("Message from thread 3");   
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
	}	
}
