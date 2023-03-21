package commandpattern;

public class CatOwner {

	Command catCommands[] = new Command[3];

	CatOwner() {
		for (int i = 0; i < catCommands.length; i++) {
			catCommands[i] = new Command() {

				@Override
				public void execute() {
					System.out.println("Some dummy command");
				}

			};
		}
	}

	public void setSlot(int slot, Command command) {
		catCommands[slot] = command;
	}

}
