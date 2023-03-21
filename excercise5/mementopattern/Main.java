package mementopattern;

public class Main {
	public static void main(String[] args) {
		GitHub project = new GitHub("memento pattern","a pattern that holds the memory of a previous object and able to restore from current state to previous state");
		
		System.out.println("<-------INITIAL STATE------->");
		project.displayProjectStatus();
		
		GitHubCareTaker memento = project.backupThisProject();
		
		System.out.println("<-------STATE CHANGED------->");
		project.projectDescription = "a pattern does not holds the memory of previous state of the object";
		project.displayProjectStatus();
		
		System.out.println("<-------RESTORING THE PREVIOUS STATE------->");
		project.restoreToPrevious(memento);
		project.displayProjectStatus();
		
	}
}
