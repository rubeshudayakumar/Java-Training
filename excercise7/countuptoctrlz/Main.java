package countuptoctrlz;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		
		String line;
		
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			System.out.println("No of chars : "+line.length());
		}
		System.out.println("Program exited");
		scanner.close();
	}
}
