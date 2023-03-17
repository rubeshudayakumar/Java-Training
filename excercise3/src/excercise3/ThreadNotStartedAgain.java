package excercise3;

public class ThreadNotStartedAgain {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			System.out.println("Thread Started");
		});
		
		try {
			t.start();
			t.start();
		}
		catch(IllegalThreadStateException e) {
			System.out.println(e);
		}
	}
}
