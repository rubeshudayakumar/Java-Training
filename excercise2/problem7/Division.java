import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        // setting up scanner
        Scanner scanner = new Scanner(System.in);

        // defining the loop
        while(true){

            // handling the exception
            try{
                int numerator,divisor;
                String data;

                // getting numerator from the user
                System.out.println("Enter the numerator : ");
                data = scanner.next();

                // checking if it is equal to q or Q if yes quit the loop
                if(data.compareTo("q")==0 || data.compareTo("Q")==0){
                    break;
                }

                // parsing the numerator assuming it is a string else it throws number format exception
                numerator = Integer.parseInt(data);

                // getting the divisor from the user
                System.out.println("Enter the divisor : ");
                data = scanner.next();

                // parsing the dinominator
                divisor = Integer.parseInt(data); 

                // printing the result
                System.out.println(numerator+"/"+divisor+" = "+(numerator/divisor));
            }

            // catching the number format exception
            catch(NumberFormatException e){
                System.out.println("poor input value");
            }
            // catching the arithmetic exception
            catch(ArithmeticException e){
                System.out.println("cannot divide by zero");
            }
            // catching the general exception
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
