package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.JiraTicketGeneration;
import POJO.Jirafields;
import POJO.Location;
import POJO.ProjectJira;
import POJO.Serialzation;
import POJO.issuetype;
import StepDescription.SkuPreviewURL_Books;

public class TestData {

	public Serialzation DataBody(String name ,String address, String Phonenumber) {
		
Serialzation bodydata= new Serialzation();
		
		bodydata.setAccuracy(50);
		bodydata.setAddress(address);
		bodydata.setLanguage("English");
		bodydata.setName(name);
		bodydata.setPhone_number(Phonenumber);
		List<String> Mylist = new ArrayList<String>();
		Mylist.add("Near Adress");
		Mylist.add("TESTlIST");
		Location L = new Location();
		L.setLat(-9879879);
		L.setLng(+878788);
		bodydata.setLocation(L);
		
		return bodydata;
		
	}
	
	public String deleteJsonBody(String Place_ID) {
		
		return "{\r\n"
				+ "    \"place_id\": \""+Place_ID+"\"\r\n"
				+ "}";
		
		
	}
public static String JiraCreateissue(String CommentNew) {
		
		
		return ("{\\r\\n\"\r\n"
				+ "				+ \"    \\\"body\\\": \\\"\""+CommentNew+"\"\\\",\\r\\n\"\r\n"
				+ "				+ \"    \\\"visibility\\\": {\\r\\n\"\r\n"
				+ "				+ \"        \\\"type\\\": \\\"role\\\",\\r\\n\"\r\n"
				+ "				+ \"        \\\"value\\\": \\\"Administrators\\\"\\r\\n\"\r\n"
				+ "				+ \"    }\\r\\n\"\r\n"
				+ "				+ \"}");
		
	}

	
	public String jiraloginDetails() {
		
		
		return("{\r\n"
				+ "    \"username\": \"ajaymareedu666\",\r\n"
				+ "    \"password\": \"ajayharshi9J@\"\r\n"
				+ "}");
		
	}
	
	
	public Jirafields jiraCreateIssuePayload(String FailedReason) {
		
	
		JiraTicketGeneration Data= new JiraTicketGeneration();
		Data.setDescription(""+FailedReason+"");
		Data.setSummary(""+FailedReason+"");
		issuetype issue= new issuetype();
		issue.setName("Bug");
		Data.setIssuetype(issue);
		ProjectJira pJ= new ProjectJira();
		pJ.setKey("DEMO");
		Data.setProject(pJ);
		
		Jirafields jirafields = new Jirafields();
		jirafields.setFields(Data);;

		
		
		return jirafields;
	}
	public void APIBody() {
		
		
		
		
		
	}
	

}




