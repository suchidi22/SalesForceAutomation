package com.Teckarch.SalesForce;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

	public class SFDCTest12 extends BaseTest{

			public static void main(String[] args) throws InterruptedException {
				Login();
				OpenAccountsPage();
				EditView();
				
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
			public static void EditView() {
				WebElement EditView =driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
				EditView.click();
				WebElement viewName = driver.findElement(By.xpath("//input[@id =\"fname\"]"));
				viewName.clear();
				viewName.sendKeys("Arjun2");
				WebElement FieldDropdown = driver.findElement(By.xpath("//select[@id='fcol1']"));
				Select ob1= new Select (FieldDropdown);
				ob1.selectByVisibleText("Account Name");
				WebElement operatorDropdown = driver.findElement(By.xpath("//select[@id='fop1']"));
				Select ob2 =new Select ( operatorDropdown );
				ob2.selectByVisibleText("contains");
				WebElement value = driver.findElement(By.xpath("//input[@id =\"fval1\"]"));
				value.sendKeys("a");
				
			}

}
