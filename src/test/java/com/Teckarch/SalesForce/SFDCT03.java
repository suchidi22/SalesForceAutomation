package com.Teckarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT03 extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		String actual ="rememberme checkbox should be checked";
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.id("username"));
			enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		 enterText (password,"allow@123","password");
		Thread.sleep(2000);
		WebElement rememberme =driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
		rememberme.click();
		System.out.println("checkbox checked");
		driver.findElement(By.id("Login")).click();
		WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
        usermenue.click();
      //move mouse pointer on dropbox menu
        Actions actions =new Actions(driver);
        actions.moveToElement(usermenue).perform();
        driver.findElement(By.linkText("Logout")).click();
	
		
	}

}
