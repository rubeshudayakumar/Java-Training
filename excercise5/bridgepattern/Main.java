package bridgepattern;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select your operating system");
		System.out.println("1.Windows\n2.Linux");
		
		int option = scanner.nextInt();
		
		FileDownloader fileDownloader;
		
		if(option==1) { 
			fileDownloader = new WindowsDownloader(); 
		}else {
			fileDownloader = new LinuxDownloader();
		}
		
		ChromeBrowser browser = new ChromeBrowser(fileDownloader);
		browser.downloadFile();
		browser.storeFile();
		
		scanner.close();
	}
}



