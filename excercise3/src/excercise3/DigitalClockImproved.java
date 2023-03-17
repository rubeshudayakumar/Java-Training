package excercise3;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DigitalClockImproved {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		DigitalClockMT ds = new DigitalClockMT();
		
		es.execute(() -> {
			while(true) {
				ds.updateSecond();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		es.execute(() -> {
			while(true) {
				ds.updateMinute();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		es.execute(() -> {
			while(true) {
				ds.updateHour();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}

class DigitalClockMT{
	
	static LocalDateTime date = LocalDateTime.now();	
	
	static int hour = date.getHour();
	static int minute =  date.getMinute();
	static int second = date.getSecond();
	
	synchronized public void updateSecond() {
		if(second%60==0) {
			second = 0;
		}
		if(minute%60 == 0) {
			minute = 0;
		}
		if(hour%24 == 0) {
			hour = 0;
		}
		second++;
		System.out.println(hour+" : "+minute+" : "+second);
		notifyAll();
	}
	synchronized public void updateMinute() {
		if(second%60!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			minute++;
			System.out.println(hour+" : "+minute+" : "+second);
		}
	}
	synchronized public void updateHour() {
		if(minute%60!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			hour++;
			minute++;
			System.out.println(hour+" : "+minute+" : "+second);
		}
	}
}
