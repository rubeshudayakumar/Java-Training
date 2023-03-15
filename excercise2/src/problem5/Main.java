package problem5;
import problem4.NegativeNumberException;

public class Main {
public static void main(String[] args) throws NegativeNumberException {
        
        // creating the class which contains the throws keyword 
        ThrowsMethod throwsMethodObject = new ThrowsMethod();
        throwsMethodObject.throwException();
    }
}
