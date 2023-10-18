package StepDescription;

import java.io.IOException;

import io.cucumber.java.Before;



public class Hooks {
	
	@Before("@DeletePlace")
	//Test should execute before the delete method if there is no value in Place_ID
	
	public void BeforeDelMethodPreCondition() throws IOException {
		if (AddPlaceClass.Place_ID==null) {            //Call elements with Class name if they given as "STATIC"
		AddPlaceClass methods = new AddPlaceClass();
		methods.add_the_base_uri_with_qureyprams_along_with("Ajay", "testAddress", "98798797979");
		methods.send_the_https_method_and_http_request_with_the_resource_details("addPlaceAPI", "Post");
		methods.validate_the_reponse_using_method("Ajay", "getPlaceAPI");
	}}

		
		
	}
	
	
	

