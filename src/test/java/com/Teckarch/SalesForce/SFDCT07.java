package com.Teckarch.SalesForce;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT07 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(4000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"allow@123","password");
		driver.findElement(By.id("Login")).click();
		////*[@id="userNav"]
         WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
         usermenue.click();
         //Thread.sleep(5000);
         driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
         Actions actions =new Actions(driver);
         actions.moveToElement(usermenue).build().perform();
         driver.findElement(By.linkText("My Settings")).click();
         driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
     
         WebElement personal =driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[4]/div[2]/a[1]"));
      personal.click();
      
      //WebElement personallink = driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/a"));
     // personallink.click();
     // Thread.sleep(4000);
   // WebElement loginHistory = driver.findElement(By.id("LoginHistory_font"));
      //  loginHistory.click();
       //  //  Actions action1 =new Actions(driver);
          // action1.moveToElement(loginHistory).build().perform();
         //
      
	}

}
