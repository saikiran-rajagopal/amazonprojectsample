package org.amazonproducts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EvenTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/table.html");
		
		WebElement alltable = driver.findElement(By.tagName("table"));
		String printalltable = alltable.getText();
		System.out.println(printalltable);
		//driver.findElement(By.cssSelector(cssSelector))
		//Print all value in first row
		
		List<WebElement> allrows = driver.findElements(By.tagName("tr"));
		//Find out Number of rows available in webPage
		System.out.println(allrows.size());
		
		for (int i =0; i<allrows.size(); i++) {
			if(i==0) {
				WebElement rowdata = allrows.get(i);
				System.out.println(rowdata.getText());
				
			}
		}
		
		//Print Even rows  available in 4th webtable
		for (int i=0; i<allrows.size(); i++) {
			if(i%2==0) {
				WebElement getevendata = allrows.get(i);
				System.out.println(getevendata.getText());
			}
		}
						
	}

}
