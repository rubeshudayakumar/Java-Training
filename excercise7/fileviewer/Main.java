package fileviewer;

import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		try (
				FileReader fileReader = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/fileviewer/somefile.txt");
			) {
			char charBuffer[] = new char[128];
			
			while((fileReader.read(charBuffer))!=-1) {
				String content = new String(charBuffer);
				System.out.println(content);
				Thread.sleep(1000);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

