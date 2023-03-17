package excercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountHundred {
	public static void main(String[] args) throws Exception {
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		es.execute(()->{
			int counter = 1;
			while(counter<=100) {
				System.out.println(counter);
				if(counter%10 == 0) {
					System.out.println("10 Numbers completed");
				}
				counter++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		es.shutdown();
	}
}
