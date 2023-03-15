package problem8;

import java.util.Scanner;

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
                total+=subjectMark;
                markCount++;
            }
            catch(NumberFormatException e){
                // printing the message to the user
                System.out.println("Marks should be a number");
            }
        }

        average = total/10.0f;
        System.out.println("The average mark of 10 students is "+(average));

    }
}
