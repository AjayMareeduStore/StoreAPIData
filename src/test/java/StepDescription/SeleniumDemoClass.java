package StepDescription;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SeleniumDemoClass {
	

	public static void main(String[] args) throws InterruptedException {
	 
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
		driver.findElement(By.xpath("//div[@class='modal-content']/div/button[2]")).click();
		driver.findElement(By.cssSelector("select.form-control")).click();
		driver.findElement(By.xpath("//select[@class='form-control']/option[3]")).click();
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		driver.getTitle();
//		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
//		Select dropdown = new Select(options);
//		dropdown.selectByValue("consult");
		int sizeOfProducts=driver.findElements(By.xpath("//button[@class='btn btn-info']")).size();
		
		for(int i=1;i<=sizeOfProducts;i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("(//button[@class='btn btn-info'])["+i+"]")).click();
			
		}
	       driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	     int sizeOfAddToCartProdcuts=driver.findElements(By.xpath("//h4[@class='media-heading']/a")).size();
	     
	     for(int x=1;x<=sizeOfAddToCartProdcuts;x++) {
	    	 
	    	String namesOfProductsCart= driver.findElement(By.xpath("(//h4[@class='media-heading']/a)["+x+"]")).getText();
	    	System.out.println(namesOfProductsCart); 
	    	 
	     }
	}

}
