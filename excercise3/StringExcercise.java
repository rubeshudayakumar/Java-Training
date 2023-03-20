package excercise3;

public class StringExcercise {
	public static void main(String[] args) {

		StringBuffer stringBuffer = new StringBuffer("A");

		StoreString threadOne = new StoreString(stringBuffer);
		StoreString threadTwo = new StoreString(stringBuffer);
		StoreString threadThree = new StoreString(stringBuffer);

		threadOne.start();
		threadTwo.start();
		threadThree.start();

	}
}

class StoreString extends Thread {
	StringBuffer stringBuffer;

	StoreString(StringBuffer stringBuffer) {
		this.stringBuffer = stringBuffer;
	}

	public void run() {
		synchronized (stringBuffer) {
			int i = 1;
			while (i++ < 100) {
				System.out.print(this.stringBuffer);

			}
			stringBuffer.setCharAt(0, (char) (stringBuffer.charAt(0) + 1));
			System.out.println();
		}
	}
}