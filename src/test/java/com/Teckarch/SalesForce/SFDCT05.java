package com.Teckarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT05 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"allow@123","password");

		driver.findElement(By.id("Login")).click();
		
         WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
         usermenue.click();


	}

}
