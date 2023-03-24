package countnumberofwordsinstring;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		String s;
		System.out.println("Enter the string : ");
		s = scanner.nextLine();
		byte stringInBytes[] = s.getBytes();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(stringInBytes)));
		
		int c;
		
		int wordCount = 0;
		
		while((c=bufferedReader.read())!=-1) {
			if(c==32) {
				wordCount++;
			}
		}
		wordCount++;
		
		System.out.println("No of words in the string is : "+wordCount);
		
		scanner.close();
	}
}
