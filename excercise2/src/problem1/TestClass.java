package problem1;

import java.util.Scanner;

public class TestClass {
	public void throwException(){
		int a = 10;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer : ");
		int b = scanner.nextInt();
		System.out.println(a/b);
    }
}
