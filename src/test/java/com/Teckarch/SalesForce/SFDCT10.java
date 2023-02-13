package com.Teckarch.SalesForce;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDCT10 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		Login();
		OpenAccountsPage();
		CreateNewAccount();		
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
	
	public static void CreateNewAccount() {
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		ClosePopupWindow();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		By accountName =  By.name("acc2");
		WebElement accountNameTextbox = driver.findElement(accountName);
		js.executeScript("arguments[0].value='Matangini'", accountNameTextbox);
		
		By billingCity = By.name("acc17city");
		WebElement billingCityTextbox =  driver.findElement(billingCity);
		js.executeScript("arguments[0].value='Poway'", billingCityTextbox);
		
		/*WebElement Type =driver.findElement(By.xpath("//*[@id=\"acc6\"]"));
		Actions actions =new Actions(driver);
        actions.moveToElement(Type).build().perform();
        driver.findElement(By.linkText("Technology Partner")).click();*/
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
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	

}
