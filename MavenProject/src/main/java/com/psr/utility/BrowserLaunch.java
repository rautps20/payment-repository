package com.psr.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BrowserLaunch {
	
	public static WebDriver driver ;	//Globle instance variable 
	
	public static Properties prop; 		//Globle instance variable 
	
	@BeforeSuite (alwaysRun=true)
	public void launchBrowser () {
		ReadPropertyFile ();										// direct call of static method
		
		if (prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Testing Programe\\Eclipse\\Framework_Projects\\Resource\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (prop.getProperty("browsername").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "");
			 driver = new EdgeDriver();
			
		}
		else {
			System.setProperty("webdriver.gecko.driver", "");
		    driver= new FirefoxDriver();
		
		}
	
	driver.get(prop.getProperty("url"));						// by get method we can call 3 browser with same object 
	driver.manage().window().maximize();
	
}
	
	

public static void ReadPropertyFile () {
	
	prop = new Properties();
	try {
		prop.load(new FileInputStream("D:\\Testing Programe\\Eclipse\\Framework_Projects\\src\\com\\psr\\utility\\config.properties"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
