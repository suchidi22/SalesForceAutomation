package com.Teckarch.SalesForce;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SFDCTest13 extends BaseTest{

		public static void main(String[] args) throws InterruptedException {
			Login();
			OpenAccountsPage();
			 MergeAccounts ();
			
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
		public static void MergeAccounts() {
			WebElement mergelink = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
			 mergelink .click();
			WebElement FindAccounts =driver.findElement(By.xpath("//input[@name=\"srchbutton\"]"));
			FindAccounts.click();
			WebElement FindClick =driver.findElement(By.xpath("//input[@id='srch']"));
			 FindClick.sendKeys("United");
			
			 WebElement FindClick1 =driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
			 FindClick1.click();
			WebElement next = driver.findElement(By.xpath("//input[@name=\"goNext\"]"));
			next.click();
			WebElement merge =	driver.findElement(By.xpath("//input[@name=\"save\"]"));
			merge.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		////*[@id="tryLexDialog"]/div[1]/div		
	//pop up close
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
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
		}
}
