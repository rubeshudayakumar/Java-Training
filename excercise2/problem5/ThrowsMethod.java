public class ThrowsMethod {

    // defining the exception with throws keyword and own exception
    public void throwException() throws NegativeNumber{
        System.out.println("from throw exception method");
        throw new NegativeNumber("negative value");
    }
}
