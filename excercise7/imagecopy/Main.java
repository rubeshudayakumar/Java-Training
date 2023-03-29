package imagecopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		
		try(
				FileInputStream sourceImage = new FileInputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/imagecopy/sunset.jpg");
				FileOutputStream destinationImage = new FileOutputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/imagecopy/sunsetDest.jpg");
				
			){
			byte byteBuffer[] = new byte[32];
			
			while((sourceImage.read(byteBuffer))!=-1) {
				destinationImage.write(byteBuffer);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
