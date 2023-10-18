package StepDescription;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDescriptionClass {

	@Given("Hit the Required URL and enter the valid login details Username {string} and Pass {string}")
	public void hit_the_required_url_and_enter_the_valid_login_details_username_and_pass(String string, String string2) {
	  
	System.out.println(string);
	System.out.println(string2);
		
	}

	@Given("Click on login button and navigate to Home page")
	public void click_on_login_button_and_navigate_to_home_page() {
	    System.out.println("Home Page Logged in");
	}

	@When("Select the required product")
	public void select_the_required_product() {
	   
	}

	@When("Add to the cart")
	public void add_to_the_cart() {
	   
	}

	@Then("Click on the required confirm order")
	public void click_on_the_required_confirm_order() {
	    
	}

	@Then("Enter the card deatails")
	public void enter_the_card_deatails() {
	  
	}

	@Then("Place the order")
	public void place_the_order() {


	}
	@When("Click on the my account details")
	public void click_on_the_my_account_details() {
	   	}

	@When("navigate to the order history page")
	public void navigate_to_the_order_history_page() {
	    
	}

	@Then("Validate the orderdetails as required")
	public void validate_the_orderdetails_as_required() {
	  
	}

	@Then("Click on logout")
	public void click_on_logout() {
	   	}
	}

