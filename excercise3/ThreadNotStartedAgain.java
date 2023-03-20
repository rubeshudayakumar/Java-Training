package excercise3;

public class ThreadNotStartedAgain {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("Thread Started");
		});

		try {
			thread.start();
			thread.start();
		} catch (IllegalThreadStateException e) {
			System.out.println(e);
		}
	}
}
