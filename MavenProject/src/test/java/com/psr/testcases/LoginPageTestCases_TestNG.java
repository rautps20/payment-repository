
// 'enabled' attribute => by default value of enabled is true.
		// when we want to stop the execute flow of perticular test case then use 'enabled' with @Test annotation
		// After apply 'enabled = false' condition then this test case will not run anytime

// 'invocationcount' attribute => when we want to run testcase more than one time.
		// @Test (invocationcount =5)

// 'Disruption' attribute => it is used for to give the test case name of that method in String
		// @ Test (disruption = "Verify that user should be able to login"

// 'groups' attribute => when we want to run multiple test cases in different testing module then we can create a groups with
		// there testing name like :- (groups = {"sanity","regression"})
		// we have to create code in xml file to run with there group name in sequence as
		// <groups> , <run>, <include name ="sanity">
		// By this it will run as per there group name

// 'alwaysRun' attribute => when we want to run specific method of test case is run every time then use 'alwaysRun' attribute
		// This attribute mostly used in @Before or @ After annotation
		// It's value is in boolean. like :- @BeforeSuite (alwaysRun=true)

// 'priority' attribute => By 'priority' attribute it will decide the method run flow as per given condition with priority
		// By default test case methods will be run as alphabetically as per method name but if we give 
		// 'priority' attribute it will be run as priority condition
package com.psr.testcases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.psr.pages.HomePage;
import com.psr.pages.LoginPage;
import com.psr.utility.BrowserLaunch;

public class LoginPageTestCases_TestNG extends LoginPage {

	@Test (description="Verify that user should not be able to login with invalid credential", priority =2)
	public void TC2 ( ) {
		//BrowserLaunch brolaunObj = new BrowserLaunch ();
		//brolaunObj.launchBrowser ();
		
		LoginPage loginPage = new LoginPage("admin1" , "admin123");
		//loginPage.userLogin();
		
		List<WebElement> errorMessageElement = BrowserLaunch.driver.findElements(By.id("spanMessage"));
		
		if (errorMessageElement.size()>0) {
		if (errorMessageElement.get(0).getText().equalsIgnoreCase("Invalid credentials"))
			System.out.println("Test Case is pass - user is unable to login with invalid crediential and System is showing as  "
						+errorMessageElement.get(0).getText());
		}
		else 
			System.out.println("Test Case is fail - user is able to login with valid crediential");
		
	}
	
	@Test (description="Verify that user should be able to login with valid credential", priority =1)
	public void TC1() {
		//BrowserLaunch brolaunObj = new BrowserLaunch ();
		//brolaunObj.launchBrowser ();
		
		LoginPage loginPage = new LoginPage("Admin" , "admin123");
		//loginPage.userLogin("Admin" , "admin123");
		
		if (BrowserLaunch.driver.getCurrentUrl().contains("dashboard"))
			System.out.println("Test Case is pass - user is able to login with valid crediential");
		else 
			System.out.println("Test Case is fail - user is unable to login with valid crediential");
	
		//BrowserLaunch.driver.quit();
	
	
	}
	
	@AfterMethod 
	public void PostCondition () throws InterruptedException {
		System.out.println("---- This is a Post Condition Method----");
		HomePage homePage = new HomePage();
		
		List<WebElement> welcomelink = homePage.getWelcomeLink();
		if (welcomelink.size()>0) {
			welcomelink.get(0).click();
			
			Thread.sleep(1000);
		
		homePage.getLogOutLink().get(0).click();
		
		}
		
	}
	 
}
