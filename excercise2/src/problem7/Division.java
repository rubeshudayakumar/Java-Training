package problem7;

import java.util.InputMismatchException;
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
                // getting numerator from the user
                System.out.println("Enter the numerator : ");
                numerator = scanner.nextInt();

                // getting the divisor from the user
                System.out.println("Enter the divisor : ");
                divisor = scanner.nextInt();

                // printing the result
                System.out.println(numerator+"/"+divisor+" = "+(numerator/divisor));
            }
            // catching the number format exception
            catch(InputMismatchException e){
                // scanner.next();
                String data = scanner.next();
                // checking if it is equal to q or Q if yes quit the loop
                if(data.compareTo("q")==0 || data.compareTo("Q")==0){
                	System.out.println("program has finished!");
                    break;
                }
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

