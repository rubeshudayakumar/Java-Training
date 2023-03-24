package charbychar;

import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		FileReader charReader = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/charbychar/sample.txt");
		FileWriter charWriter = new FileWriter("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/charbychar/sampleDest.txt");
		
		int c;
		
		while((c=charReader.read())!=-1) {
			charWriter.write(c);
		}
		charReader.close();
		charWriter.close();
	}
}
