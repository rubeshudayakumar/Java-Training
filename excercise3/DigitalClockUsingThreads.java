package excercise3;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DigitalClockUsingThreads {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);

		DigitalClock digitalClock = new DigitalClock();

		es.execute(() -> {
			while (true) {
				digitalClock.updateSecond();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		es.execute(() -> {
			while (true) {
				digitalClock.updateMinute();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		es.execute(() -> {
			while (true) {
				digitalClock.updateHour();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

	}
}

class DigitalClock {

	static LocalDateTime date = LocalDateTime.now();

	static int hour = date.getHour();
	static int minute = date.getMinute();
	static int second = date.getSecond();

	synchronized public void updateSecond() {
		if (second % 60 == 0) {
			second = 0;
		}
		if (minute % 60 == 0) {
			minute = 0;
		}
		if (hour % 24 == 0) {
			hour = 0;
		}
		System.out.println(hour + " : " + minute + " : " + second);
		second++;
		notifyAll();
	}

	synchronized public void updateMinute() {
		if (second % 60 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			minute++;
		}
	}

	synchronized public void updateHour() {
		if (minute % 60 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			hour++;
			minute++;
		}
	}
}