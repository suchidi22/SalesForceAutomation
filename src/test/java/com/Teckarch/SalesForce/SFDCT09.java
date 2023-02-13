package com.Teckarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDCT09 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(4000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"allow@123","password");
		driver.findElement(By.id("Login")).click();
		WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
        usermenue.click();
      //move mouse pointer on dropbox menu
        Actions actions =new Actions(driver);
        actions.moveToElement(usermenue).build().perform();
        driver.findElement(By.linkText("Logout")).click();
	
	}

}
