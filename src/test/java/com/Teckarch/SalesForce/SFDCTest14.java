package com.Teckarch.SalesForce;


	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class SFDCTest14 extends BaseTest{

			public static void main(String[] args) throws InterruptedException {
				Login();
				OpenAccountsPage();
				 AccountReport();
				
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
			public static void  AccountReport() {
				WebElement lastActivity= driver.findElement(By.xpath("//a[contains(text(),\"Accounts with last activity > 30 days\")]"));
	                  lastActivity.click();
	                  WebElement dateFielddropdown = driver.findElement(By.xpath("//input[@name =\"dateColumn\"]"));
	                  dateFielddropdown.click();
	                  WebElement createdDate = driver.findElement(By.xpath("//*[@id=\"ext-gen266\"]/div[3]"));
	                  Select ob1 = new Select (createdDate);
	                  ob1.selectByVisibleText("Created Date");

}
}