package org.amazonproducts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.netty.util.internal.SystemPropertyUtil;

public class DropDownOne {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		Robot bot = new Robot();
		driver.findElement(By.xpath("//img[@title='Ad.Plus Advertising']")).click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("textarea")).click();
		
		bot.keyPress(KeyEvent.VK_TAB);
		bot.keyRelease(KeyEvent.VK_TAB);
		bot.keyPress(KeyEvent.VK_DOWN);
		bot.keyRelease(KeyEvent.VK_DOWN);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement gettext = driver.findElement(By.xpath("//div[@class=' css-yk16xz-control']"));
		String text = gettext.getAttribute("Value");
		System.out.println(text);	
	}
	

}
