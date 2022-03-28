package org.amazonproducts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDeal {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win10\\eclipse-workspace\\AmazonTask\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/table.html ");
		
		WebElement printtable = driver.findElement(By.tagName("table"));
		String text = printtable.getText();
		System.out.println(text);
		
		List<WebElement> alltablerow = driver.findElements(By.tagName("tr"));
		
		Set st = new HashSet(alltablerow);
		st.addAll(alltablerow);
		System.out.println(st.contains("2"));
		
		for (int i=0; i<alltablerow.size(); i++) {
			if (i==2) {
			WebElement rows = alltablerow.get(i);
			System.out.println(rows.getText());
			}
		}
		
		for (int i = 0 ; i<alltablerow.size(); i++) {
			WebElement rows = alltablerow.get(i);
			
			List<WebElement> alltabledata = rows.findElements(By.tagName("td"));
			
			for (int j =0; j<alltabledata.size(); j++) {
				if (j==1) {
				WebElement tabledata = alltabledata.get(j);
				System.out.println(tabledata.getText());
				
				
				String text2 = tabledata.getText();
				if (text2.contains("6")) {
				System.out.println(text2);
				
					}
				}
			}
		}
				
	}
}
