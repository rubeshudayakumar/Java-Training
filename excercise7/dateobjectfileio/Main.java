package dateobjectfileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/dateobjectfileio/date.dat"));
		
		LocalDateTime date = LocalDateTime.now();
		
		System.out.println("Date before writing the object : "+date);
		objectOutputStream.writeObject(date);
		
		objectOutputStream.close();
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/dateobjectfileio/date.dat"));
		
		LocalDateTime readedDate = (LocalDateTime) objectInputStream.readObject();
		
		System.out.println("Date after reading from the file "+readedDate);
		
		objectInputStream.close();
		
	}
}
