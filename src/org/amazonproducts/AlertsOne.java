package org.amazonproducts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertsOne {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		Actions act = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement findElement1 = driver.findElement(By.xpath("//li[@class='placeholder'][1]"));
		act.dragAndDrop(findElement, findElement1).perform();
		
	}

}
