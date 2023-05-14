package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	//By Locators or Object Repository
	private By HelloBtn = By.id("nav-link-accountList-nav-line-1");
	private By emailId = By.id("ap_email");
	private By continueBtn = By.id("continue");
	private By password =By.id("ap_password");
	private By SignInButton =By.id("signInSubmit");
	private By LogoutlinkLocator = By.id("nav-item-signout");
	private By forgotPasswordLink =By.linkText("");
	private By errormessageLocator = By.className("a-alert-heading");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void clickHelloBtn() {
		driver.findElement(HelloBtn).click();
	}
	public void enterUserName(String UserName) {
		driver.findElement(emailId).sendKeys(UserName);
	}
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	public void enterPassword(String Pwd) {
		driver.findElement(password).sendKeys(Pwd);
	}
	
	public void clickOnSignIn() {
		driver.findElement(SignInButton).click();
	}
	public boolean checkLogoutLink() {
		return driver.findElement(LogoutlinkLocator).isDisplayed();
	}
	
	public boolean errorMessageDisplayed() {
		return driver.findElement(errormessageLocator).isDisplayed();
	}

}
