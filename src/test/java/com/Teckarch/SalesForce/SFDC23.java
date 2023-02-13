package com.Teckarch.SalesForce;
	
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
         public class SFDC23 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		Login();
		OpenLeadsPage();
		ClosePopupWindow();
		LeadsDropDownShowAllValues();
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
	public static void OpenLeadsPage() {
		WebElement leads = driver.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
        leads.click();
	}
	
	public static void LeadsDropDownShowAllValues() throws InterruptedException {
		//WebElement leadsDropDown = driver.findElement(By.xpath(" //select[@id='fcf']"));
		//leadsDropDown.click();
		//Thread.sleep(5000);
		WebElement  leadsDropDown= driver.findElement(By.xpath("//select[@id='fcf']"));
		Select ob = new Select (leadsDropDown);
		ob.selectByVisibleText("Today's Leads");
		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
  		go.click();
		
	
		
}
}