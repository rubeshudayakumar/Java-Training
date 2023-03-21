package mementopattern;

public class GitHub {
	
	public String projectName;
	public String projectDescription;
	
	public GitHub(String projectName, String projectDescription) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
	}

	public GitHubCareTaker backupThisProject() {
		return new GitHubMemento(this.projectName,this.projectDescription);
	}
	
	public void restoreToPrevious(GitHubCareTaker memento) {
		this.projectName = ((GitHubPreviousProject)memento).getProjectName();
		this.projectDescription = ((GitHubPreviousProject)memento).getProjectDescription();
	}
	
	public void displayProjectStatus() {
		System.out.println("project name : "+this.projectName);
		System.out.println("project description : "+this.projectDescription);
	}
	
}
