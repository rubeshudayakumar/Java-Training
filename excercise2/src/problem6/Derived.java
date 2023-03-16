package problem6;

public class Derived extends Base{
	
    Derived() {
//        System.out.println("Derived class constructor");
    	try {
    		System.out.println("Derived class constructor colled");
        }
        catch(NumberFormatException e) {
        	System.out.println("Error from base");
        }
    	catch(Exception e) {
    		System.out.println("Some error occured!");
    	}
    }
    
}

