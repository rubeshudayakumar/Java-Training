package imagecopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		FileInputStream sourceImage = new FileInputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/imagecopy/sunset.jpg");
		FileOutputStream destinationImage = new FileOutputStream("/Users/rubeshu/Documents/Java Eclipse/excercise7/src/imagecopy/sunsetDest.jpg");
		
		byte b[] = new byte[32];
		
		while((sourceImage.read(b))!=-1) {
			destinationImage.write(b);
		}
		
		sourceImage.close();
		destinationImage.close();
	}
}
