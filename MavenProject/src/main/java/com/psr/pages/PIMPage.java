package com.psr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PIMPage extends HomePage {

	public PIMPage (String username, String password) {
		super (username, password);
	}
	
	public WebElement getAddEmployeeBtn () {
		return driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		
	}
	
	public WebElement getFirstNametxt () {
		return driver.findElement(By.id("firstName"));
		
	}
	public WebElement getLastNametxt () {
		return driver.findElement(By.id("lastName"));
		
	}
	public WebElement getSaveBtn () {
		return driver.findElement(By.id("btnSave"));
		
	}
	
	public void AddEmployee (String firstname, String lastname) {
		getFirstNametxt().sendKeys(firstname);
		getLastNametxt().sendKeys(lastname);
		getSaveBtn().click();
	}
}
