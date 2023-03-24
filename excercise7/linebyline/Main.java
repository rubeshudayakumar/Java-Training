package linebyline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/linebyline/sample.txt"));
		
		PrintWriter printWriter = new PrintWriter("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/linebyline/sampleDest.txt");
		
		
		String line;
		
		while((line=bufferedReader.readLine())!=null) {
			printWriter.write(line+"\n");
		}
		
		System.out.println("File written successfully!");
		
		bufferedReader.close();
		
		printWriter.close();
		
	}
}
