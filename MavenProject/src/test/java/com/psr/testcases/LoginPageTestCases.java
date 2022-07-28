
// Repetative Code => Create method

package com.psr.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.psr.pages.LoginPage;
import com.psr.utility.BrowserLaunch;

public class LoginPageTestCases {

	public static void main(String[] args) {
		
		//BrowserLaunch brolaunObj = new BrowserLaunch ();		after create @Before Suite it is not required
		//brolaunObj.launchBrowser ();
		
//invalid Credential
		
		LoginPage loginPage = new LoginPage ("Admin1","admin123");
		//loginPage.userLogin();
		
		List<WebElement> errorMessageElement = BrowserLaunch.driver.findElements(By.id("spanMessage"));
		
		if (errorMessageElement.size()>0) {
		if (errorMessageElement.get(0).getText().equalsIgnoreCase("Invalid credentials"))
			System.out.println("Test Case is pass - user is unable to login with invalid crediential and System is showing as  "+errorMessageElement.get(0).getText());
		}
		else 
			System.out.println("Test Case is fail - user is able to login with valid crediential");
		
//Valid Credential
		loginPage.userLogin("Admin" , "admin123");
		
		if (BrowserLaunch.driver.getCurrentUrl().contains("dashboard"))
			System.out.println("Test Case is pass - user is able to login with valid crediential");
		else 
			System.out.println("Test Case is fail - user is unable to login with valid crediential");
	
		BrowserLaunch.driver.quit();
	
	}

}
