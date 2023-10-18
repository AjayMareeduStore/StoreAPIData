package StepDescription;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.Console;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.ExcelIntegrationCode;
import Resources.SeleniumJavaMethods;
import Resources.TestData;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

@RunWith(Cucumber.class)

public class SkuPreviewURL_Books extends Utils {

	Response JiraApi;
	SessionFilter session = new SessionFilter();
	String SessionID;
	String failedresponse;
	String Title;
	String Title1;
	String NameOfEachDesign;
	String designIDString;
	String ptype;
	String pcat;
	String skuID;
	String filters;
	String defaultSkuSelection;
	String pdpPageURl;
	String category;
	String dgId;
	String designId;
	String sku;
	String pdppcat;
	String scat;
	String PDPptype;
	String[] ignoreLinks;
	String names;
	List<String> al;

	WebDriver driver = new ChromeDriver();

	@Given("User should be able to navigate to home page with logged in state")
	public void user_should_be_able_to_navigate_to_home_page_with_logged_in_state()
			throws InterruptedException, IOException {

		try {

			snapfishUsBetaSignup(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			if (pageTitle.equalsIgnoreCase("Snapfish | Personalized Gifts, Cards, Home Decor, Photo Books & More")) {
				driver.get(GeturlGlobal("prodPhotoBookurl"));
				getApiParameters(driver);
				booksBspApiMethod(driver);
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ldapLogin(driver);
			snapfishUsBetaSignup(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			if (pageTitle.equalsIgnoreCase("Snapfish | Personalized Gifts, Cards, Home Decor, Photo Books & More")) {
				driver.get(GeturlGlobal("prodPhotoBookurl"));
				getApiParameters(driver);

			}
		}

	}

	@When("User should be able to navigate to the books page as expected")
	public void user_should_be_able_to_navigate_to_the_books_page_as_expected() {

		System.out.println("**********Script Execution of Books Bsp pages Done**********");
	}

	@Then("Split the url and store it in the payload to run API Test")
	public void split_the_url_and_store_it_in_the_payload_to_run_api_test() {

	}

	@Given("Arrange the BASEURI and Required parameter")
	public void arrange_the_baseuri_and_required_parameter() throws IOException {

	}

	@When("Able to the hit the Post call with the arrange data")
	public void able_to_the_hit_the_post_call_with_the_arrange_data() {

	}

	@Then("verify the data received for the statuscode is the url")
	public void verify_the_data_received_for_the_statuscode_is_the_url() {

		//
		// String resp =response.asString();
		// JsonPath js = new JsonPath(resp);
		// System.out.println("CommerceProductID looking for ("+skuID+")");
		// int count = js.getInt("designGroups.size()");
		// System.out.println("Total No Design Groups available in /photo-gift/api/v1
		// are = "+count+"");
		// for (int Q=0; Q<count;Q++) {
		// String NameofDesignGroup=js.getString("designGroups["+Q+"].name");
		// System.out.println("Name of the designGroup is ("+NameofDesignGroup+")");
		// //Size of the each Design in Design_Group
		// int SizeOfDesigns=js.getInt("designGroups["+Q+"].designs.size()");
		// for (int P=0; P<SizeOfDesigns;P++) {
		// NameOfEachDesign=js.getString("designGroups["+Q+"].designs["+P+"].name");
		// int
		// sizeOfSkuList=js.getInt("designGroups["+Q+"].designs["+P+"].skuList.size()");
		// for (int M=0; M<sizeOfSkuList;M++) {
		// NameOfTheSkus=js.get("designGroups["+Q+"].designs["+P+"].skuList["+M+"]");
		//
		// if(NameOfTheSkus.equalsIgnoreCase(""+skuID+"")) {
		//
		// Title1=js.get("designGroups["+Q+"].designs["+P+"].skuPreviewUrlMap."+NameOfTheSkus+".title");
		// System.out.println("*title of the Sku previewURL for ("+NameOfTheSkus+") is -
		// *"+Title1+"*");
		//
		//
		// if(Title1==null) {
		//
		// failedresponse ="For the ("+NameOfEachDesign+") design skupreviewurl
		// attribute is *Missing*";
		// System.out.println(failedresponse);
		//
		// /*RestAssured.baseURI= "http://localhost:8080";
		// given().relaxedHTTPSValidation().header("Content-Type","application/json")
		// .body(testdata.jiraloginDetails())
		// .filter(session).when().post("/rest/auth/1/session")
		// .then().assertThat().statusCode(200).extract().response();
		//
		//
		// given().relaxedHTTPSValidation().header("Content-Type","application/json")
		// .body(testdata.jiraCreateIssuePayload(failedresponse))
		// .filter(session)
		// .when().post("/rest/api/2/issue")
		// .then().log().body().assertThat().statusCode(201).extract().response();
		//
		//
		// System.out.println("Issue created");
		// Assert.assertEquals(true, false);*/
		//
		// }
		//
		// }
		//
		// }
		//
		//
		// }
		//
		// }
	}

	@When("User should be able to navigate to the books PDP page as expected")
	public void user_should_be_able_to_navigate_to_the_books_pdp_page_as_expected() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.findElement(By.xpath("//a[@id='selectedQVDesignTile-14']")).click();
		// driver.findElement(By.xpath("//*[@id=\"dimensions\"]/multisurface-size/div/ul/li[6]/div[2]")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[@class='link-active see-full-link
		// upsell-variation ng-star-inserted']")).click();
		// Thread.sleep(3000);
		// String pdpPageURl=driver.getCurrentUrl();
		// System.out.println(pdpPageURl);
	}

	@Then("Split the PDP Page url and store it in the payload to run API Test")
	public void split_the_pdp_page_url_and_store_it_in_the_payload_to_run_api_test() {
		// pdpPageURl=driver.getCurrentUrl();
		// String url5=pdpPageURl.split("category=")[1];
		// System.out.println(category=url5.split("&dgId")[0]);
		// String url6=pdpPageURl.split("dgId=")[1];
		// System.out.println(dgId=url6.split("&designId")[0]);
		// String url7=pdpPageURl.split("designId=")[1];
		// System.out.println(designId=url7.split("&sku=")[0]);
		// String url8=pdpPageURl.split("sku=")[1];
		// System.out.println(sku=url8.split("&ptype")[0]);
		// String url9=pdpPageURl.split("pcat=")[1];
		// System.out.println(pdppcat=url9.split("&scat")[0]);
		// String url1=pdpPageURl.split("scat=")[1];
		// System.out.println(scat=url1.split("&filters")[0]);
		// String url2=pdpPageURl.split("ptype=")[1];
		// System.out.println(PDPptype=url2.split("&pcat")[0]);
		// driver.quit();
		//
	}

	@Given("Arrange the BASEURI and Required parametes for pdp page")
	public void arrange_the_baseuri_and_required_parametes_for_pdp_page() throws IOException {
		// GivenData =
		// given().relaxedHTTPSValidation().spec(BooksPDPPage(category,dgId,designId,
		// sku,
		// pdppcat,scat,PDPptype));
	}

	@When("Able to the hit the Post call with the arrange negative check data")
	public void able_to_the_hit_the_post_call_with_the_arrange_negative_check_data() {

		// response=GivenData.when().get("photo-gift/api/v1/design-product-details/locale/en_US")
		// .then().extract().response();
		//
		// resp=new
		// ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@Then("verify the data received for the statuscode is the pdp url")
	public void verify_the_data_received_for_the_statuscod_is_the_pdp_url() {
		// String resp =response.asString();
		// JsonPath js1 = new JsonPath(resp);
		// int count = js1.getInt("designGroup.designs.size()");
		// System.out.println("Total No Design Groups available in
		// /photo-gift/api/v1/design-product-details are = **"+count+"**");
		// String DesignGroupName= js1.get("designGroup.name");
		// System.out.println("Designgroup name is ("+DesignGroupName+")");
		//
		// for (int P=0; P<count;P++) {
		// String NameOfTheEachDesign=js1.getString("designGroup.designs["+P+"].name");
		// int SizeOfTheSkuList=js1.get("designGroup.designs["+P+"].skuList.size()");
		// for (int H=0; H<SizeOfTheSkuList;H++) {
		// String NameOfTheSkuID=js1.get("designGroup.designs["+P+"].skuList["+H+"]");
		// if(NameOfTheSkuID.equalsIgnoreCase(""+sku+"")){
		//
		// Title=js1.get("designGroup.designs["+P+"].skuPreviewUrlMap."+NameOfTheSkuID+".title");
		// System.out.println("*title of the Sku previewURL for ("+NameOfTheSkuID+") is
		// - *"+Title+"*");
		//
		//
		// if(Title==null) {
		//
		// failedresponse ="For the ("+NameOfTheEachDesign+") design skupreviewurl
		// attribute is *Missing*";
		// System.out.println(failedresponse);

		/*
		 * RestAssured.baseURI= "http://localhost:8080";
		 * given().relaxedHTTPSValidation().header("Content-Type","application/json")
		 * .body(testdata.jiraloginDetails())
		 * .filter(session).when().post("/rest/auth/1/session")
		 * .then().assertThat().statusCode(200).extract().response();
		 * 
		 * 
		 * given().relaxedHTTPSValidation().header("Content-Type","application/json")
		 * .body(testdata.jiraCreateIssuePayload(failedresponse)) .filter(session)
		 * .when().post("/rest/api/2/issue")
		 * .then().log().body().assertThat().statusCode(201).extract().response();
		 * 
		 * 
		 * System.out.println("Issue created"); Assert.assertEquals(true, false);
		 */

		//
		// }

	}

	/*
	 * if (sizeOfSkuPreviewMaps==null) {
	 * 
	 * RestAssured.baseURI= "http://localhost:8080";
	 * given().relaxedHTTPSValidation().header("Content-Type","application/json")
	 * .body(testdata.jiraloginDetails())
	 * .filter(session).when().post("/rest/auth/1/session")
	 * .then().log().all().assertThat().statusCode(200).extract().response();
	 * 
	 * 
	 * given().relaxedHTTPSValidation().header("Content-Type","application/json")
	 * .body(testdata.jiraCreateIssuePayload(failedresponse)) .filter(session)
	 * .when().post("/rest/api/2/issue")
	 * .then().log().all().assertThat().statusCode(201).extract().response();
	 * 
	 * 
	 * System.out.println("Issue created");
	 * 
	 * } else {
	 * 
	 * 
	 * System.out.println("(****Executions Ends****)");
	 * 
	 * }
	 */

}
