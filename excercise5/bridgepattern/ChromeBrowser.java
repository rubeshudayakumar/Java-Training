package bridgepattern;

public class ChromeBrowser implements BrowserDownloadManager{
	
	FileDownloader downloader;
	
	public ChromeBrowser(FileDownloader downloader) {
		this.downloader = downloader;
	}

	@Override
	public void downloadFile() {
		downloader.downloadFile();
	}

	@Override
	public void storeFile() {
		downloader.storeFile();
	}

}
