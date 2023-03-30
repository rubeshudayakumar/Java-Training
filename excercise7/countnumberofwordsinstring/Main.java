package countnumberofwordsinstring;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try(
				Scanner scanner = new Scanner(System.in);
			){
			String text;
			System.out.println("Enter the string : ");
			text = scanner.nextLine();
			
			text = text.trim();
			
			int wordCount = 1;
			
			for (int i = 0; i < text.length() - 1; i++)
	        {
	            if ((text.charAt(i) == ' ') && (text.charAt(i + 1) != ' '))
	            {
	                wordCount++;
	            }
	        }	
			if(text.trim().length()==0) {
				wordCount = 0;
			}
			System.out.println("No of words in the string is : "+wordCount);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
