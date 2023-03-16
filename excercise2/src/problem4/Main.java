package problem4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        try{
            // getting the input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number greater than 0 : ");
            int number = scanner.nextInt();
            scanner.close();

            // checking if the number is less than zero
            if(number<0){
                throw new NegativeNumberException("Number should not be negative");
            }
            
            // catching the exception which is thrown from the try block
        }catch(NegativeNumberException e){
            System.out.println(e);
        }
    }
}
