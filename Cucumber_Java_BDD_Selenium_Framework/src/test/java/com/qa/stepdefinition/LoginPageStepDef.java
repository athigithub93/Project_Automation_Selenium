package com.qa.stepdefinition;

import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given(": User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get("https://www.amazon.in/");
	}

	@When(": User gets the title of the page")
	public String user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Title of the page is " + title);
		return title;
	}

	@Then(": Page title should be {string}")
	public void page_title_should_be(String ExpectedTitleName) {
		// String title =loginpage.getLoginPageTitle();
		Assert.assertTrue(title.contains(ExpectedTitleName));
		// Assert.assertEquals(title, ExpectedTitleName);

	}

	@Given("user clicks on the HelloBtn")
	public void user_clicks_on_the_hello_btn() {
		loginpage.clickHelloBtn();

	}

	@Given("User enter a valid username")
	public void user_enter_a_valid_username() {
		loginpage.enterUserName("");
	}

	@Given("User clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		loginpage.clickContinueBtn();

	}

	@Given("User enter a valid password")
	public void user_enter_a_valid_password() {
		loginpage.enterPassword("");
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		loginpage.clickOnSignIn();

	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		Assert.assertEquals(loginpage.checkLogoutLink(), true);

	}
	@Given("User entered invalid {string} and {string}")
	public void user_entered_invalid_and(String username, String password) {
	    loginpage.enterUserName(username);
	    loginpage.clickContinueBtn();
	    loginpage.enterPassword(password);
	}
	

	@Then("User should see an error message indicating {string}")
	public void user_should_see_an_error_message_indicating(String error_message) {
	    Assert.assertEquals(loginpage.errorMessageDisplayed(), true);
	}



}