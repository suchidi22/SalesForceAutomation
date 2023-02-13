package com.Teckarch.SalesForce;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
         public class SFDC24 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		Login();
		OpenLeadsPage();
		ClosePopupWindow();
		Save();

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
	public static void OpenLeadsPage() {
		WebElement leads = driver.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
        leads.click();
        WebElement newbtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
          newbtn.click();
          
         WebElement lastname = driver.findElement(By.xpath("//input[@id =\"name_lastlea2\"]"));
          lastname.sendKeys("ABCD");
          WebElement company = driver.findElement(By.id("lea3"));
			company.sendKeys("ABCD");
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
			
	public static void Save() {
			WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
			save.click();
			}
			
	}
