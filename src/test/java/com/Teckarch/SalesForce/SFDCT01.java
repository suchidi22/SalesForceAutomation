package com.Teckarch.SalesForce;

import java.net.PasswordAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//driver.findElement(By.id("Login")).click();
import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT01 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		 String expected ="Please enter your password.";
		 GetDriverInstance("chrome");
			goToUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"","password");
		Thread.sleep(5000);
		driver.findElement(By.id("Login")).click();
		WebElement textElement = driver.findElement(By.id("error"));
		 if (textElement.isDisplayed()) {
			 //String actual = textElement.getText();
			 String actual = GetTextFromWebElement(textElement);
			 if(actual.equalsIgnoreCase(expected)) {
        	 System.out.println("SFDC login error - test case is passed");
			 }
         }
         else {
        	 System.out.println("SFDC login error - test case is failed");
         }
		
	}

}
