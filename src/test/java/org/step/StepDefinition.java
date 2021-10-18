package org.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	public WebDriver driver;
	
	@Given("user have to launch the browser and enter the url")
	public void user_have_to_launch_the_browser_and_enter_the_url() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://en-gb.facebook.com/");
	}

	@When("user enters the invalid username and valid password")
	public void user_enters_the_invalid_username_and_valid_password() {
		
		WebElement txtUser = driver.findElement(By.id("email"));

		txtUser.sendKeys("Java");

		WebElement txtPass = driver.findElement(By.id("pass"));

		txtPass.sendKeys("Java@123");
	   
	}

	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		
     WebElement btnLogin = driver.findElement(By.name("login"));
		
		btnLogin.click();
	}

	@Then("user not display the homepage of the application")
	public void user_not_display_the_homepage_of_the_application() {
	  
		System.out.println("User should not navigate to the home page");
	}


}
