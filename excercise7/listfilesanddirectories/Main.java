package listfilesanddirectories;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File directory = new File("/Users/rubeshu/Documents/Java Eclipse/excercise7/src");
		
		String filesAndFoldersList[] = directory.list();
		
		System.out.println("listing all the files and directories in the current folders");
		
		for(String fileName : filesAndFoldersList) {
			System.out.println(fileName);
		}
		
	}
}
