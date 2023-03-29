package charbychar;

import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args){
		try(
				FileReader charReader = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/charbychar/sample.txt");
				FileWriter charWriter = new FileWriter("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/charbychar/sampleDest.txt");
			) {
			
			char character;
			
			while((character=(char)charReader.read())!=-1) {
				charWriter.write(character);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
