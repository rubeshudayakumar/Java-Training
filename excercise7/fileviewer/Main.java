package fileviewer;

import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		FileReader fileReader = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/fileviewer/somefile.txt");
		
		char buffer[] = new char[128];
		
		while((fileReader.read(buffer))!=-1) {
			String content = new String(buffer);
			System.out.println(content);
		}
		fileReader.close();
	}
}
