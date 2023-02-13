package com.Teckarch.SalesForce;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SFDCTest16 extends BaseTest{

		public static void main(String[] args) throws InterruptedException {
			Login();
			opportunitieslink();
			ClosePopupWindow();
			CreateNewOpportunity();
			
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
		
		public static void opportunitieslink() {
			WebElement opportunities= driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
			opportunities.click();
		}
			public static void ClosePopupWindow() {
				driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]")).click();
				System.out.println(driver.getWindowHandle());
				String popupWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String x: windows ) {
					if(x.equals(popupWindow) ==false) {
						driver.switchTo().window(x);
						break;
					}
				}
				System.out.println(driver.getCurrentUrl());//driver.findElement(By.xpath("/")).click();

				System.out.println(driver.getTitle());
			}
		
		public static void CreateNewOpportunity() {
			WebElement createnew = driver.findElement(By.xpath("//span[@id='createNewLabel']"));
			createnew.click();
			WebElement opportunityClick = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[6]"));
			opportunityClick.click();
		  
		  	JavascriptExecutor js = (JavascriptExecutor)driver;
			By opName =  By.name("opp3");
			WebElement opNameTextbox = driver.findElement(opName);
			js.executeScript("arguments[0].value='Opportunity1'", opNameTextbox);
			
			By accountName = By.name("opp4");
			WebElement accountNameTextBox = driver.findElement(accountName);
			js.executeScript("arguments[0].value='Account1234'", accountNameTextBox);
		
			
			WebElement closeDateDatePicker = driver.findElement(By.xpath("//input[@id='opp9']"));
			closeDateDatePicker.sendKeys("02/10/2023");
			closeDateDatePicker.sendKeys(Keys.TAB);
			
			WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
			stage.sendKeys("Prospecting");
			
			WebElement probability = driver.findElement(By.xpath("//input[@id='opp12']"));
			probability.sendKeys(".08");
			
	     
	    
		}
}