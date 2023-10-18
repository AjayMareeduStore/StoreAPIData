package Resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDescription.SkuPreviewURL_Books;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class Utils {
	static String SessionID;
	static String failedresponse;
	static String Title;
	static String Title1;
	static String NameOfEachDesign;
	static String designIDString;
	static String ptype;
	static String pcat;
	static String skuID;
	static String filters;
	static String defaultSkuSelection;
	String pdpPageURl;
	static RequestSpecification GivenData;
	static ResponseSpecification resp;
	TestData testdata = new TestData();
	static Response response;
	static String sizeOfSkuPreviewMaps;
	static String NameOfTheSkus;
	RequestSpecification Data;
	public static RequestSpecification BaseURI;

	public RequestSpecification utils() throws IOException {

		if (BaseURI == null) {
			PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
			BaseURI = new RequestSpecBuilder().setBaseUri(GeturlGlobal("baseURl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return BaseURI;
		}
		return BaseURI;
	}

	public static String GeturlGlobal(String Key) throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\ajay.mareedu\\CucumberFrameWork\\Automation\\src\\test\\java\\Resources\\Global.properties");
		prop.load(file);
		return prop.getProperty(Key);

	}

	public String getJsonPath(Response response, String key) {

		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();

	}

	public String getBSPJsonPath(Response response, String key) {

		String Resp = response.asString();
		JsonPath js = new JsonPath(Resp);
		return js.get(key);

	}

	public static RequestSpecification BooksBSP;

	public static RequestSpecification booksBspPage() throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		BooksBSP = new RequestSpecBuilder().setBaseUri(GeturlGlobal("prodBooksURL")).

				addQueryParam("buildNumber", "2221696487497000").addQueryParam("context", "/hp/sf/sf-us/snapfish-us")
				.addQueryParam("ptype", ptype).addQueryParam("pcat", pcat).addQueryParam("filters", filters)
				.addQueryParam("offset", "0").addQueryParam("sku", skuID).addQueryParam("deviceType", "pc")
				.addQueryParam("defaultSkuSelection", defaultSkuSelection).addQueryParam("skipFacets", "true")
				.addQueryParam("multisurface", "true").addQueryParam("incSkuPreviews", "true")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		return BooksBSP;
	}

	public RequestSpecification BooksPDP;

	public RequestSpecification BooksPDPPage(String category, String dgId, String designId, String sku, String pdppcat,
			String scat, String PDPptype) throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		BooksPDP = new RequestSpecBuilder().setBaseUri(GeturlGlobal("prodBooksURL")).

				addQueryParam("buildNumber", "2231696288936000").addQueryParam("context", "/hp/sf/sf-us/snapfish-us")
				.addQueryParam("cobrand", "snapfish").addQueryParam("website", "snapfish_us")
				.addQueryParam("ptype", PDPptype).addQueryParam("category", category).addQueryParam("dgId", dgId)
				.addQueryParam("designId", designId).addQueryParam("pcat", pdppcat).addQueryParam("sku", sku)
				.addQueryParam("scat", scat).addQueryParam("withSku", "SNP").addQueryParam("incNLDesigns", "true")
				.addQueryParam("deviceType", "pc").addQueryParam("sortCriteria", "toppicks")
				.addQueryParam("multisurface", "true").addQueryParam("incSkuPreviews", "true")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		return BooksPDP;

	}

	public static RequestSpecification JiraBaseURI;

	public RequestSpecification Jira() throws IOException {

		if (JiraBaseURI == null) {
			PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
			JiraBaseURI = new RequestSpecBuilder().setBaseUri(GeturlGlobal("JiraBase"))
					.addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return JiraBaseURI;
		}
		return JiraBaseURI;
	}

	public static int generateRandomNumber() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000000);

		return randomInt;
	}

	public static void ldapLogin(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("ajay.mareedu");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Hanuman@123");
		driver.findElement(By.xpath("//a[@name='log in']")).click();

	}

	public static void snapfishUsBetaSignup(WebDriver driver) throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(GeturlGlobal("prodExecutionUrl"));
		driver.findElement(By.xpath("(//a[contains(text(),'Sign Up')])[2]")).click();
		driver.findElement(By.xpath("//input[@id='email']"))
				.sendKeys("StoreAutomation" + generateRandomNumber() + "@yopmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ajay@123");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Store");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//*[@id=\"1409504737172\"]/div[3]/div[1]/fieldset/div/form[2]/div[6]/a")).click();
		Thread.sleep(3000);
		String homePageTitle = driver.findElement(By.xpath("//div[contains(text(),'Welcome to Snapfish!')]")).getText();
		Assert.assertEquals(homePageTitle, "Welcome to Snapfish!");

	}

	public static void getApiParameters(WebDriver driver) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mt-promo-drawer\"]/div[2]/div[1]/div[2]/img")).click();

		List<WebElement> bspPageUrls = driver
				.findElements(By.xpath("//div[@class='small-6 columns end ']/div[2]/div[2]/ul/li/a"));

		for (int i = 1; i <= bspPageUrls.size(); i++) {

			driver.get(GeturlGlobal("prodPhotoBookurl"));

			String names = driver
					.findElement(By.xpath("(//div[@class='small-6 columns end ']/div[2]/div[2]/ul/li/a)[" + i + "]"))
					.getAttribute("href");
			System.out.println(names);
			String[] ignoreLinks = { "https://www.snapfish.com/softcover-photo-book-7x5-details",
					"https://www.snapfish.com/hardcover-photo-book-7x5-details" };
			List<String> al = Arrays.asList(ignoreLinks);

			if (al.contains(names)) {

				System.err.println("*****this link is not related to bsp page******");

			} else {

				driver.get(names);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				String bspPageURL = driver.getCurrentUrl();
				String currentPageTitle = driver.getTitle();
				System.out.println(bspPageURL);
				System.out.println(currentPageTitle);
				String Url = bspPageURL.split("ptype=")[1];
				ptype = Url.split("&pcat")[0];
				String url1 = bspPageURL.split("pcat=")[1];
				pcat = url1.split("&sku")[0];
				String url2 = bspPageURL.split("sku=")[1];
				skuID = url2.split("&filters")[0];
				String url3 = bspPageURL.split("filters=")[1];
				filters = url3.split("&offset")[0];
				String url4 = bspPageURL.split("defaultSkuSelection=")[1];
				defaultSkuSelection = url4.split("&bspOffset")[0];
				System.out.println("*********Api Query Parameters**********");
				System.out.println(ptype);
				System.out.println(pcat);
				System.out.println(skuID);
				System.out.println(filters);
				System.out.println(defaultSkuSelection);
				System.out.println("*********Api Query Parameters**********");
				booksBspApiMethod(driver);

			}
		}
	}

	public static void booksBspApiMethod(WebDriver driver) throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		GivenData = given().relaxedHTTPSValidation().spec(booksBspPage());
		response = GivenData.when()
				.get("/photo-gift/api/v1/design-catalog/locale/en_US/cobrand/snapfish/website/snapfish_us").then()
				.extract().response();
		resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		System.out.println("CommerceProductID looking for (" + skuID + ")");
		int count = js.getInt("designGroups.size()");
		System.out.println("Total No Design Groups available in /photo-gift/api/v1 are = " + count + "");
		for (int Q = 0; Q < count; Q++) {
			String NameofDesignGroup = js.getString("designGroups[" + Q + "].name");
			System.out.println("Name of the designGroup is (" + NameofDesignGroup + ")");
			// Size of the each Design in Design_Group
			int SizeOfDesigns = js.getInt("designGroups[" + Q + "].designs.size()");
			for (int P = 0; P < SizeOfDesigns; P++) {
				String NameOfEachDesign = js.getString("designGroups[" + Q + "].designs[" + P + "].name");
				String designID = js.getString("designGroups[" + Q + "].designs[" + P + "].id");
				int sizeOfSkuList = js.getInt("designGroups[" + Q + "].designs[" + P + "].skuList.size()");
				for (int M = 0; M < sizeOfSkuList; M++) {
					String NameOfTheSkus = js.get("designGroups[" + Q + "].designs[" + P + "].skuList[" + M + "]");
					if (NameOfTheSkus.equalsIgnoreCase("" + skuID + "")) {
						Title1 = js.get("designGroups[" + Q + "].designs[" + P + "].skuPreviewUrlMap." + NameOfTheSkus
								+ ".title");
						System.out.println(
								"*title of the Sku previewURL for (" + NameOfTheSkus + ") is - *" + Title1 + "*");

						if (Title1 == null) {

							failedresponse = "For the (" + NameOfEachDesign + ") Design_ID (" + designID
									+ ") design skupreviewurl attribute is *Missing*";
							System.err.println(failedresponse);

						}
					}

				}

			}

		}

	}
}
