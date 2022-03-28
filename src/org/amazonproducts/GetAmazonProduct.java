package org.amazonproducts;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GetAmazonProduct {
	
	public static WebDriver driver;
	
	public static void screenshots(String filename) throws IOException {
		TakesScreenshot s = (TakesScreenshot)driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\screenshots\\"+filename+".png"); 
		FileUtils.copyFile(src, dest);
		
	}
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//go to google 		
		driver.get("https://www.google.com/");
		
		//maximize chrome browser window
		driver.manage().window().maximize();
		//locator - search box & send keys
		driver.findElement(By.name("q")).sendKeys("Amazon.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Amazon.Com']")).click();
		screenshots("google");
		//to perform cursor actions
		Actions act = new Actions(driver);
		//to perform right click and open new tab
		WebElement amazonlink = driver.findElement(By.xpath("//h3[text()='Amazon.com. Spend less. Smile more.']"));
		act.contextClick(amazonlink).perform();
		//to perform keyboard operations
		Robot bot = new Robot();
		bot.keyPress(KeyEvent.VK_DOWN);
		bot.keyRelease(KeyEvent.VK_DOWN);
		
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
		//navigation to different windows
		Thread.sleep(2000);
		Set<String> winHandles = driver.getWindowHandles();
		System.out.println(winHandles);
		
		List <String> li = new ArrayList<>();
		li.addAll(winHandles);
		
		//go to amazon home page tab
		driver.switchTo().window(li.get(1));
		screenshots("amazon");
		//enter search terms and click on search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		act.click(searchbtn).perform();
		screenshots("Amazon search results");
		//number of search items per page
		List <WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of Iphone's Per Page is : " + list.size());
		//to get product details
		WebElement productname = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
		String productlist = productname.getText();
		System.out.println(productlist);
		//to find number of frames in the webpage
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number Of Frames in this page : " +frames.size());
		
	}

}
