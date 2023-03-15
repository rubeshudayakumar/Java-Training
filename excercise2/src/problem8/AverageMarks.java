package problem8;

import java.util.Scanner;

import problem4.NegativeNumberException;
import problem9.OutOfRangeException;

public class AverageMarks {
	public static void main(String[] args) {

        // setting up the scanner
        Scanner scanner = new Scanner(System.in);
        float total=0.0f,average;
        String mark;
        int markCount = 1;

        // looping to 10 times
        while(markCount<=10){
            try{
                // getting the marks from the user
                System.out.println("Enter the mark for subject "+markCount+" : ");
                mark = scanner.next();
                
                // parsing the mark input throws number format exception else follows the loop
                int subjectMark = Integer.parseInt(mark); 
                // adding mark to the total incrementing the markcount
                
                if(subjectMark<0) {
                	throw new NegativeNumberException("Mark should not be negative");
                }
                
                if(subjectMark<0 || subjectMark>100) {
                	throw new MarkInvalidException("Mark should be between the range 0-100");
                }
                
                total+=subjectMark;
                markCount++;
            }
            catch(NumberFormatException e){
                // printing the message to the user
                System.out.println("Marks should be a number");
            }
            catch(NegativeNumberException e) {
            	System.out.println(e.getMessage());
            }
            catch(MarkInvalidException e) {
            	System.out.println(e.getMessage());
            }
            catch(Exception e) {
            	System.out.println("Some error occured");
            }
        }

        average = total/10.0f;
        System.out.println("The average mark of 10 students is "+(average));

    }
}
