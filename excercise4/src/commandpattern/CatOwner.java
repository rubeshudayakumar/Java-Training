package commandpattern;

public class CatOwner {
	
	Command catCommand[] = new Command[3];
	
	CatOwner() {
		for(int i=0;i<catCommand.length;i++) {
			catCommand[i] = new Command() {

				@Override
				public void execute() {
					System.out.println("Some dummy command");
				}
				
			};
		}
	}
	
	public void setSlot(int slot,Command command) {
		catCommand[slot] = command;
	}
	
}
