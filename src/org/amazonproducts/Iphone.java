package org.amazonproducts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Iphone {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone X");
		
		driver.findElement(By.xpath("//span[@id='nav-search-submit-text']")).click();
		
		Actions act = new Actions(driver);
		WebElement clickiphone = driver.findElement(By.xpath("//span[contains(text(),'iPhone X, 64GB, Space Gray')]"));
		act.contextClick(clickiphone).perform();
		
		Robot bot = new Robot();
		bot.keyPress(KeyEvent.VK_DOWN);
		bot.keyRelease(KeyEvent.VK_DOWN);
		
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		List <String> li = new ArrayList<>();
		li.addAll(windows);
		
		driver.switchTo().window(li.get(1));
		
		WebElement price = driver.findElement(By.xpath("//div[@id='corePrice_feature_div']"));
		String printprice = price.getText();
		System.out.println(printprice);
	}

}
