package com.Teckarch.SalesForce;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

         public class SFDCTest25 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		Login();
		contact();
		ClosePopupWindow();
		 newpage();

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
	public static void contact() {
		WebElement contact =driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		contact.click();
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
	public static void newpage() throws InterruptedException {
		WebElement newbtn=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newbtn.click();
		WebElement lastname = driver.findElement(By.xpath("//input[@id=\"name_lastcon2\"]"));
			lastname.sendKeys("Banerjee");	
			WebElement accountname = driver.findElement(By.xpath("//*[@id=\"con4_lkwgt\"]/img"));
			accountname.click();
		
		WebElement searchbox =driver.findElement(By.xpath(" //input[@id='lksrch']"));
		searchbox.sendKeys("United Oil & Gas, UK");
		
			//WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
			//save.click();
			
			
		
	}
	
         }
