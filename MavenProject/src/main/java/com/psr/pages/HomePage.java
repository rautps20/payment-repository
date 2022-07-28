
// When we want to run multiple testcase in one time we want to create 'testng.xml'file
// In testng.xml file automatically save all testcases classes one by one to run at one time
// So write click on testcase package=>RunAs=>Convert To TestNG=>automatically create 'testng.xml
		// open xml file it will run test cases

package com.psr.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends LoginPage{
	// Home Page Test Cases
	//FindElements and functionality
	
	public HomePage(String username, String password) {
		super (username, password);
		
	}
	
	public HomePage () {
		
	}
	
	public WebElement getPIMLink() {
		return driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		
	}
	
	public List<WebElement> getWelcomeLink () {
		return driver.findElements(By.id("welcome"));
	}
	
	public List<WebElement> getLogOutLink () {
		return driver.findElements(By.xpath("//a[text()='Logout']"));
	}
	
}
