import java.util.Scanner;

public class ProblemFourMain {
    public static void main(String[] args) {
        try{
            // getting the input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number greater than 0 : ");
            int number = scanner.nextInt();
            scanner.close();

            // checking if the number is less than zero
            if(number<0){
                throw new NegativeNumber("Number should not be negative");
            }
            
            // catching the exception which is thrown from the try block
        }catch(NegativeNumber e){
            System.out.println(e);
        }
    }
}


