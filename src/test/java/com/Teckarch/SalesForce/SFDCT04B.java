package com.Teckarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT04B extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		String expected ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"123","username");
		WebElement password =driver.findElement(By.id("password"));
		 enterText (password,"22131","password");
		Thread.sleep(5000);
		driver.findElement(By.id("Login")).click();
		
		WebElement textElement = driver.findElement(By.id("error"));
		 if (textElement.isDisplayed()) {
			//String actual = driver.findElement(By.id("error")).getText();
			 String actual = GetTextFromWebElement(textElement);
			 if(actual.equalsIgnoreCase(expected)) {
	        	 System.out.println("Your login attempt has failed - test case is passed");
				 }
			 else {
				 System.out.println("SFDC logged in - test case is failed");
			 }
		 }

	}

}
