package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
	WebDriver driver;
	
	@Given("the user is on nopCommerce login page")
	public void navigateToLoginPage() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}

	@When("the user enter valid credentials\\(username: {string},password: {string})")
	public void enterValidCredentials(String user, String pwd) {
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
	   
	}

	@When("the user clicks on Login button")
	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	   
	}

	@Then("the user should be redirected to My Account Page")
	public void navigateToMyAccountPage() {
		
		boolean myAcct=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(myAcct, true);
	   
	}

	@Then("the user should see welcome message")
	public void welcomeMessage() {
		
		boolean welcomeMsg=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
		Assert.assertEquals(welcomeMsg, true);
		driver.quit();
	}


}
