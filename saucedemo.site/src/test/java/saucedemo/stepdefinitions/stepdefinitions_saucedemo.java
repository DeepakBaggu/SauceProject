package saucedemo.stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObjectModel.POM;

public class stepdefinitions_saucedemo {

	WebDriver driver=null;

	//Hooks should be only used for low-level logic such as starting browser or deleting data from a database
	//The below function has become hook and is run Before and after of every scenario
	//If there are two "@Before" functions we can decide the order by using @Before(Order=0) or @Before(Order=1) so on..the sequence of execution will be from 0 to next
	//If there are two "@After" functions we can decide the order by using @After(Order=0) or @After(Order=1)so on..the sequence of execution will be from Last to 0
	//We also have conditional Hook that we can run depending on the tags used in the feature file like @Before(value="SmokeTest") can also be used with order like @Before(value="SmokeTest",order=1)
	//Above step will be the same for @After
	//Hooks will execute even if the scenario fails

	@Before
	public void browsersetup() {
		String projectpath=System.getProperty("user.dir");
		System.out.println("ProjectPath is:"+projectpath);
		System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/saucedemo.driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void teardown() {

		driver.close();
		driver.quit();	
	}

	@BeforeStep
	public void beforesteps() {
		System.out.println("I am inside beforesteps----");
	}

	@AfterStep
	public void Afterteps() {
		System.out.println("I am inside beforesteps----");
	}

	@Given("user launches saucedemo site in chrome bowser")
	public void user_launches_saucedemo_site_in_chrome_bowser() {
		driver.navigate().to("https://www.saucedemo.com/");
		String ActualTitle=driver.getTitle();
		System.out.println("ExpectedTitle is: "+ActualTitle);
		String ExpectedTitle="Swag Labs";
	

	}

	@And("^Enters the (.*) and (.*)$")
	public void enters_the_standard_user_and_secret_sauce(String Username,String Password) throws InterruptedException{

		POM P= new POM(driver);
		P.EnterUsername(Username);
		Thread.sleep(1000);
		P.EnterPassword(Password);
		Thread.sleep(1000);
	}

	@Then("clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException {
		POM P= new POM(driver);
		P.ButtonSingin();

	}

	@And("user clicks on logout and closes the browser")
	public void user_clicks_on_logout_and_closes_the_browser() throws InterruptedException{
		POM P= new POM(driver);
		P.TopLeft_Bar();
		Thread.sleep(1000);
		P.Logout();
		Thread.sleep(1000);

	}

	@And("user clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		POM P= new POM(driver);
		P.AddToCart_SauceLabsBackpack();

	}

	@Then("user navigates to Add to cart")
	public void user_navigates_to_add_to_cart() {
		POM P= new POM(driver);
		P.NavigateAddToCart();


	}

	@Then("Checks if the item is added to the cart")
	public void checks_if_the_item_is_added_to_the_cart() {
		POM P= new POM(driver);
		P.Validate_SaucelabsBackpack_In_Cart();


	}



}
