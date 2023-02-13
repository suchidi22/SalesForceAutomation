package com.Teckarch.SalesForce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

;

public class BaseTest {
	static WebDriver driver =null;
	public static void enterText(WebElement element, String text,String name){
		if (element.isDisplayed()) {
			element.clear(); //clear the field so that user can enter value
			element.sendKeys(text); //we need enter the value
			}
			else {
				System.out.println(name + "web element is not displayed");
			} 
		driver.getTitle();
	}
	
	
	public static void GetDriverInstance(String browserName) {
	
	switch (browserName){
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 break;
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		break;
	default:
		System.out.println("Not entered proper browser name");
	 }
	}
	
	public static void goToUrl(String url) {
		driver.get(url);
	}
	
	public static String GetTextFromWebElement(WebElement element) {
		if (element.isDisplayed())
				return element.getText();
		else
			System.out.println( "web element is not displayed");
		return null;
	}
		

	}

