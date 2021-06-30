package pageObjectModel;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class POM {

	WebDriver driver;

	By txt_Username=By.id("user-name");
	By txt_Password=By.id("password");
	By Button_Signin=By.id("login-button");
	By TopLeft_Bar=By.id("react-burger-menu-btn");
	By Link_Logout=By.id("logout_sidebar_link");
	By Button_Addcart_SauceLabsBackpack=By.id("add-to-cart-sauce-labs-backpack");
	By Navigate_AddToCart=By.id("shopping_cart_container");
	By Checking_SaucelabsBackpack_In_Cart=By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");

	//Constructor is used to call the driver in stepdefinitions_saucedemo.java class

	public POM(WebDriver driver){
		this.driver=driver;

	}

	public void EnterUsername(String Username) {
		driver.findElement(txt_Username).sendKeys(Username);

	}
	public void EnterPassword(String Password) {
		driver.findElement(txt_Password).sendKeys(Password);

	}

	public void ButtonSingin() {

		driver.findElement(Button_Signin).click();

	}
	
	public void TopLeft_Bar() {
		driver.findElement(TopLeft_Bar).click();
	}
	
	public void Logout() {
		
		driver.findElement(Link_Logout).click();
		
	}
	public void AddToCart_SauceLabsBackpack() {
		
		driver.findElement(Button_Addcart_SauceLabsBackpack).click();
		
	}
	
	public void NavigateAddToCart() {
		
		driver.findElement(Navigate_AddToCart).click();
		
	}
	
	public void Validate_SaucelabsBackpack_In_Cart() {
		
		Boolean Display=driver.findElement(Checking_SaucelabsBackpack_In_Cart).isDisplayed();
		 
	
		
	}
	
	
	
	
}
