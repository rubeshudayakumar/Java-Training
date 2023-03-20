package commandpattern;

public class IamSleepyCommand extends Command{
	Bed bed;
	Music music;
	
	@Override
	public void execute() {
		bed.giveBed();
		music.playMusic();
	}

	public IamSleepyCommand(Bed bed, Music music) {
		this.bed = bed;
		this.music = music;
	}
	
}

class Bed{
	public void giveBed() {
		System.out.println("Providing the bed");
	}
}
class Music{
	public void playMusic() {
		System.out.println("Play music");
	}
}