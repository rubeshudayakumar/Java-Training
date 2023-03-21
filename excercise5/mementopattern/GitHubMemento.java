package mementopattern;

public class GitHubMemento implements GitHubCareTaker,GitHubPreviousProject{
	
	public String projectName;
	public String projectDescription;

	public GitHubMemento(String projectName, String projectDescription) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
	}

	@Override
	public String getProjectName() {
		return this.projectName;
	}

	@Override
	public String getProjectDescription() {
		return this.projectDescription;
	}
	
}
