package org.amazonproducts;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import graphql.parser.antlr.GraphqlParser.ArgumentsContext;

public class WindowsHandle {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS );
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
		List<WebElement> iphoneRate = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Set<WebElement> iphonePrice = new HashSet<>(iphoneRate);
		for (WebElement iphone : iphonePrice) {
			System.out.println(iphone.getText());
		}
					
	}

}
