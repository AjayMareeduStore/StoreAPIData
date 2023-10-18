package StepDescription;

import static io.restassured.RestAssured.given;

import java.io.IOException;


import org.junit.Assert;
import org.junit.runner.RunWith;
import Resources.GetPlaceResource;
import Resources.TestData;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


@RunWith(Cucumber.class)
public class AddPlaceClass extends Utils { //Using Inheritance
	RequestSpecification BaseURI;
	RequestSpecification resp;
	ResponseSpecification Ressp;
	Response response;
	TestData addplace = new TestData(); //Create an object to call methods
	static String Place_ID; //Given as static to store the values even after execution
	
	@Given("Add the baseURI with qureyprams along with {string} {string} {string}")
	public void add_the_base_uri_with_qureyprams_along_with(String name, String aaddress, String phonenumber)  throws IOException {
	          //Stored the required body data in addplace and called here creating Object
		    //Stored basic details somewhere in the class and called it using object
              resp = given().spec(utils()).body(addplace.DataBody(name,aaddress,phonenumber));
	}

	@When("Send the https method {string} and {string} http request with the resource details")
	public void send_the_https_method_and_http_request_with_the_resource_details(String resource, String method) {
		
		//Used ENUM class to get the data stored and used constructor to return the data in ENUM Class
		//GetPlaceResource is the ENUM class name
		GetPlaceResource getResource=GetPlaceResource.valueOf(resource);
		
		if (method.equalsIgnoreCase("Post")) {
		 response = resp.when().post(getResource.getResources())
				 .then().extract().response();
		}
		else if (method.equalsIgnoreCase("Get"))
			 response = resp.when().get(getResource.getResources())
			 .then().extract().response();  
	}

	@Then("fecth validate the script executed and received response")
	public void fecth_validate_the_script_executed_and_received_response() {
		
		Ressp= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

	@Then("Validate the {string} is getting {string} as expected")
	public void validate_the_is_getting_as_expected(String key, String expected) {
	   
		
		Assert.assertEquals(getJsonPath(response,key),expected);
	    
	  //Created Jsonpath object in some other class by storing response and calling it here when required
	}
	
	@Then("Validate the reponse {string} using {string} method")
	public void validate_the_reponse_using_method(String ExpectedName, String resource) throws IOException {
	   
		Place_ID=getJsonPath(response,"place_id");
		System.out.println(Place_ID);
		resp = given().spec(utils()).log().all().queryParam("place_id", Place_ID);
		send_the_https_method_and_http_request_with_the_resource_details(resource, "Get");
		String name=getJsonPath(response,"name");
		Assert.assertEquals(name, ExpectedName);
		
		}
	@Given("Verify able to add the required body")
	public void verify_able_to_add_the_required_body() throws IOException {


		resp = given().spec(utils()).body(addplace.deleteJsonBody(Place_ID));
		
		
	}
	}
	
	
	

