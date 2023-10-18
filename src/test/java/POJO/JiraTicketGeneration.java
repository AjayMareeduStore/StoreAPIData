package POJO;

public class JiraTicketGeneration {

	
	private ProjectJira project;
	private String Summary;
	private String Description;
	private issuetype issuetype;
	public ProjectJira getProject() {
		return project;
	}
	public void setProject(ProjectJira project) {
		this.project = project;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		this.Summary = summary;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public issuetype getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(issuetype issuetype) {
		this.issuetype = issuetype;
	}
	
	
	
	
}
