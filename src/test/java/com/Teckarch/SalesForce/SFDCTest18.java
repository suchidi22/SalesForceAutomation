package com.Teckarch.SalesForce;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SFDCTest18 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		Login();
		opportunitieslink();
		ClosePopupWindow();
		TestStuckOpportunities();
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
	
	public static void TestStuckOpportunities() {
	WebElement stuckOpportunities = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
	stuckOpportunities.click();
	}
}
