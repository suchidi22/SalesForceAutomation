package com.Teckarch.SalesForce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDCT08 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"allow@123","password");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
         WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
         usermenue.click();
         Thread.sleep(3000);
         //move mouse pointer on dropbox menu
         Actions actions =new Actions(driver);
         actions.moveToElement(usermenue).build().perform();
         driver.findElement(By.linkText("Developer Console")).click();
         System.out.println("Developer consolde opened..  ");
         
         Set<String> getAllWindows = driver.getWindowHandles();
         Iterator <String> itr = getAllWindows.iterator();
         
  
         String parentId = itr.next();
         String childId = itr.next();
         
         Thread.sleep(8000);
         
         //traverse the method
         driver.switchTo().window(childId);
         System.out.println("Title of the child page:  "+ driver.getTitle());
         driver.switchTo().window(parentId);
  
         Actions a = new Actions(driver);
         a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
         
         
         
                 
      
	}

}
