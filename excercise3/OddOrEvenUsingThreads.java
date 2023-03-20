package excercise3;

public class OddOrEvenUsingThreads {
	public static void main(String[] args) {

		new Thread(() -> {
			int num = 1;
			while (num <= 100) {
				if (num % 2 == 0) {
					System.out.println("Even number is : " + num);
				}
				num++;
			}
		}).start();

		new Thread(() -> {
			int num = 1;
			while (num <= 100) {
				if (num % 2 != 0) {
					System.out.println("Odd number is : " + num);
				}
				num++;
			}
		}).start();

	}
}