package bridgepattern;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LinuxDownloader implements FileDownloader{
	List<String> file = new ArrayList<String>();

	@Override
	public void downloadFile() {
		try {
			FileReader br = new FileReader("/Users/rubeshu/Documents/Java Eclipse/excercise5/src/bridgepattern/linuxDownloader.txt");
			int readSize;
			char buffer[] = new char[32];
			
			while((readSize=br.read(buffer))!=-1) {
				file.add(new String(buffer,0,readSize));
			}
			
			System.out.println("linux file successfully downloaded");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void storeFile() {
		try {
			PrintWriter fr = new PrintWriter("/Users/rubeshu/Documents/Java Eclipse/excercise5/src/bridgepattern/linuxStore.txt");
			
			for(String line:file) {
				fr.append(line);
			}
			
			System.out.println("File stored to linux successfully");
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
