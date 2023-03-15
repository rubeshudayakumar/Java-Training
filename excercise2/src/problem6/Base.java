package problem6;

import java.util.Scanner;

public class Base {
    Base(){
        System.out.println("Base class constructor called");
//        throw new Exception("SOME ERROR :(");
        String s;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter some number : ");
        
        s = scanner.next();
        
        int a = Integer.parseInt(s);
    }
}
