
// POM = Page Object Model
// Create one class of each page of your application
// We will have page related locators & methods to support functionality
	// Functionality like => 1) login 2) Forgot Password
// We need to have one method for each functionality
	// eg. UserName, Password, LoginButton, Forgot Password 



package com.psr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.psr.utility.BrowserLaunch;

public class LoginPage extends BrowserLaunch {

	public LoginPage(String username, String password) {
		userLogin (username, password);
		
	}
	
	public LoginPage () {
		
	}
	
	public WebElement getUserNametxt () {
		return driver.findElement(By.id("txtUsername"));
	}
	
	public WebElement getPassword () {
		return driver.findElement(By.id("txtPassword"));
	}
	
	public WebElement getLoginbtn () {
		return driver.findElement(By.id("btnLogin"));
	}
	
	/*public WebElement getForgotPasswordLink () {
		return driver.findElement(By.id("btnLogin"));	
		
	*/
	public void userLogin (String username, String password) {
		getUserNametxt().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginbtn().click();
	
	}
	
}
