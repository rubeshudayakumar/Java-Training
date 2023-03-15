package problem6;

public class Base {
    Base() throws Exception{
        System.out.println("Base class constructor called");
        throw new Exception("SOME ERROR :(");
    }
}
