package com.Teckarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT04A extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		 enterText (password,"allow@123","password");
		WebElement forgotpassword =driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]"));
		Thread.sleep(2000);
		forgotpassword.click();

	}

}
