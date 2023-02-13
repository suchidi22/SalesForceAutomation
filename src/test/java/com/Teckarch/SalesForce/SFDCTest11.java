package com.Teckarch.SalesForce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDCTest11 extends BaseTest{

		public static void main(String[] args) throws InterruptedException {
			Login();
			OpenAccountsPage();
			createNewview();
				
		}
		
		public static void Login() throws InterruptedException {
			GetDriverInstance("chrome");
			goToUrl("https://login.salesforce.com/");
			Thread.sleep(4000);
			WebElement username = driver.findElement(By.id("username"));
			enterText(username,"suchi@tekarch.com","username");
			WebElement password =driver.findElement(By.id("password"));
			enterText (password,"allow@123","password");
			driver.findElement(By.id("Login")).click();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	
		}
		
		public static void OpenAccountsPage() {
			WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
	        Actions actions =new Actions(driver);
	        actions.moveToElement(usermenue).perform();
	        driver.findElement(By.linkText("Accounts")).click();
		}
		public static void createNewview() {
		WebElement createNewView=	driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNewView.click();
		WebElement viewName = driver.findElement(By.xpath("//input[@id =\"fname\"]"));
		viewName.sendKeys("Arjun");
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id =\"devname\"]"));
		 viewUniqueName.sendKeys("krishna");
		 WebElement savebtn = driver.findElement(By.xpath("//input[@name=\"save\"]"));
		 savebtn.click();
		 
		}
		}


