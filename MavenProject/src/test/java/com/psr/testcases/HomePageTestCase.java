package com.psr.testcases;

import org.testng.annotations.Test;

import com.psr.pages.HomePage;
import com.psr.pages.LoginPage;
import com.psr.pages.PIMPage;
import com.psr.utility.BrowserLaunch;

public class HomePageTestCase extends LoginPage {
	// Home page Test case
	
	@Test (description="Verify that admin should be able to add new employee")
	public void TC3 () {
		//BrowserLaunch brolaunObj = new BrowserLaunch (); =>after create @Before Suite it is not required
		//brolaunObj.launchBrowser ();
		
		PIMPage pimpage = new PIMPage("Admin" , "admin123");
		//pimpage.userLogin();
	
		if (BrowserLaunch.driver.getCurrentUrl().contains("dashboard"))
			System.out.println("Test Case is pass - user is able to login with valid crediential");
		else 
			System.out.println("Test Case is fail - user is unable to login with valid crediential");

//it will be save memory	
		pimpage.getPIMLink().click();
		pimpage.getAddEmployeeBtn().click();
		pimpage.AddEmployee("Test", "Software");
		
		
	}
	
	
	
}
