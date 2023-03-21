package bridgepattern;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WindowsDownloader implements FileDownloader{
	
	List<String> file = new  ArrayList<String>();
	
	@Override
	public void downloadFile() {
		try {
			FileReader br = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise5/src/bridgepattern/windowsDownloader.txt");
			int readSize;
			char buffer[] = new char[32];
			
			while((readSize=br.read(buffer))!=-1) {
				file.add(new String(buffer,0,readSize));
			}
			
			System.out.println("windows file successfully downloaded");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void storeFile() {
		try {
			FileWriter fr = new FileWriter("/Users/rubeshu/Documents/Java Eclipse/excercise5/src/bridgepattern/windowsStore.txt");
			
			for(String line:file) {
				fr.append(line);
			}
			System.out.println("File stored to windows successfully");
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
