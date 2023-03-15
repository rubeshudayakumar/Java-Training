package problem1;

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {

        // creating the test class object 
        TestClass object = new TestClass();
        try {
        	 object.throwException();
        }
        catch(InputMismatchException e) {
        	System.out.println("should be a number");
        }
        catch(ArithmeticException e){
        	System.out.println("cant divide by zero");
        }
        catch(Exception e) {
        	System.out.println("Some error");
        }
        
    }
}
