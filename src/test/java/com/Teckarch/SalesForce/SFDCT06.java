package com.Teckarch.SalesForce;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCT06 extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException  {
		//clickOnaboutTab();
		postfilelinkClick ();
		//Addonphotolink ();
		
	}
	public static void clickOnaboutTab() throws InterruptedException{
		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"suchi@tekarch.com","username");
		WebElement password =driver.findElement(By.id("password"));
		enterText (password,"allow@123","password");
		
		driver.findElement(By.id("Login")).click();
	
         WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
         usermenue.click();
     Thread.sleep(4000);
         WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(), 'My Profile')]"));
         myprofile.click();
         Thread.sleep(4000);
          WebElement editbutton =driver.findElement(By.xpath(" //a[@id='moderatorMutton']"));
       editbutton.click();
         Thread.sleep(3000);
         WebElement goToEditprofile =driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]"));
         goToEditprofile.click();
	}
	
         public static void postfilelinkClick () throws InterruptedException, AWTException{
        	 GetDriverInstance("chrome");
     		goToUrl("https://login.salesforce.com/");
     		Thread.sleep(2000);
 
     		WebElement username = driver.findElement(By.id("username"));
     		enterText(username,"suchi@tekarch.com","username");
     		WebElement password =driver.findElement(By.id("password"));
     		enterText (password,"allow@123","password");
     		
     		driver.findElement(By.id("Login")).click();
     		 WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
             usermenue.click();
         Thread.sleep(4000);
             WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(), 'My Profile')]"));
             myprofile.click();
             Thread.sleep(4000);
         
         WebElement post = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]")); //click on the post
         post.click();
         WebElement postbox =driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
       	driver.switchTo().frame(postbox);
       	WebElement frameBody = driver.findElement(By.xpath("/html[1]/body[1]"));
       	frameBody.click();
       	frameBody.sendKeys("hi there!!");
       	driver.switchTo().parentFrame();
       	
       	WebElement shareButton  = driver.findElement(By.xpath("//input[@id=\"publishersharebutton\"]"));
       	//shareButton.click();
       Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]")).click();//click on the file 
       //a[@id="chatterUploadFileAction"]
         WebElement uploadFile = driver.findElement(By.xpath("//a[@id=\"chatterUploadFileAction\"]"));
       uploadFile.click();
     //input[@id="chatterFile"]
       WebElement choosefile = driver.findElement(By.xpath("//input[@id=\"chatterFile\"]"));
       JavascriptExecutor executor = (JavascriptExecutor) driver;
       executor.executeScript("document.getElementById('chatterFile').click();");
     
       StringSelection stringSelection = new StringSelection("C:\\Users\\debsa\\OneDrive\\Pictures\\sp.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);//outside selenium 
		Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);//pressing the control v button ..1st 4 step
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);//press enter key
        robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(4000);
         //driver.findElement(By.xpath("//*[@id=\"publisherAttachLinkPost\"]/span[1]")).click(); //click on the file link
         
       
      
        }
         public static void Addonphotolink () throws InterruptedException{
        	 GetDriverInstance("chrome");
     		goToUrl("https://login.salesforce.com/");
     		Thread.sleep(2000);
 
     		WebElement username = driver.findElement(By.id("username"));
     		enterText(username,"suchi@tekarch.com","username");
     		WebElement password =driver.findElement(By.id("password"));
     		enterText (password,"allow@123","password");
     		
     		driver.findElement(By.id("Login")).click();
     		 WebElement usermenue = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
             usermenue.click();
         Thread.sleep(4000);
             WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(), 'My Profile')]"));
             myprofile.click();
             Thread.sleep(4000);
             WebElement moderator = driver.findElement(By.xpath("//span[@id='displayBadge']"));
             Actions action = new Actions (driver);
             action.moveToElement(moderator).build().perform();
            
             WebElement addPhoto = driver.findElement(By.xpath("//*[@id=\"uploadLink\"]"));
             addPhoto.click();
             Thread.sleep(4000);
             WebElement childwindow = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
             driver.switchTo().frame(childwindow);
             
             WebElement ChooseFile = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
             ChooseFile.sendKeys("C:\\Users\\debsa\\OneDrive\\Pictures");
             
         }   

}
