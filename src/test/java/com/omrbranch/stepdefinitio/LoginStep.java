package com.omrbranch.stepdefinitio;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;

	@Given("User is on the OmrBranch Login Page")
	public void user_is_on_the_omr_branch_login_page() {

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.omrbranch.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("User click the login button")
	public void user_click_the_login_button() {

		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	}
	@Then("User should verify successful login message after login")
	public void user_should_verify_successful_login_message_after_login() {

		String text = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).getText();
		Assert.assertTrue("Verify Successful Login", text.contains("Welcome Sathya"));
		driver.quit();
	}
}
