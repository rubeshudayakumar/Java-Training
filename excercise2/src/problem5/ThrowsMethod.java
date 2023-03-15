package problem5;

import java.util.Scanner;

import problem4.NegativeNumberException;

public class ThrowsMethod {

    // defining the exception with throws keyword and own exception
    public void throwException() throws NegativeNumberException {
    	Scanner scan = new Scanner(System.in);
        
        int number;
        
        number = scan.nextInt();
        
        if(number<0) {
        	throw new NegativeNumberException("negative value");
        }
        
    }
}

