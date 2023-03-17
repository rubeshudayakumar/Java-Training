package excercise3;

public class StringExcercise {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("A");
		
		StoreString threadOne = new StoreString(sb);
		StoreString threadTwo = new StoreString(sb);
		StoreString threadThree = new StoreString(sb);
		
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		
	}
}


class StoreString extends Thread{
	StringBuffer sb;
	
	StoreString(StringBuffer sb){
		this.sb = sb;
	}
	
	public void run() {
		synchronized(sb) {
			int i = 1;
			while(i++<100) {
				System.out.print(this.sb);
				
			}
			sb.setCharAt(0, (char)(sb.charAt(0)+1));
			System.out.println();
		}
	}
}