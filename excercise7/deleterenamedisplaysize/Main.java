package deleterenamedisplaysize;

import java.io.File;

public class Main {
	public static void main(String[] args) {
//		code for renaming the file
		File fileToBeRenamed = new File("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/deleterenamedisplaysize/dummyFile.txt");
		
		System.out.println("The current file name is : "+fileToBeRenamed.getName());
		boolean isRenamed = fileToBeRenamed.renameTo(new File("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/deleterenamedisplaysize/dummyFileRenamed.txt"));
		if(isRenamed) {
			System.out.println("The file is successfully renamed!");
		}
		
		File fileToBeDeleted = new File("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/deleterenamedisplaysize/fileToBeDeleted.txt");
		
//		code to delete the file  
		if(fileToBeDeleted.delete()) {
			System.out.println(fileToBeDeleted.getName()+"File successfully deleted");
		}
		
//		code to print the size of the file name 
		File lengthCalculationFile = new File("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/deleterenamedisplaysize/lengthCalculation.txt");
		System.out.println("size of the file "+lengthCalculationFile.length());
		
	}
}
