package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test46 {

	public static void main(String[] args) {
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/points-table-standings");
		//collect all table in page source
		List<WebElement> tables=driver.findElements(By.xpath("//table/tbody"));
		System.out.println("All tables: "+tables.size());
		//highlight visable
		for(WebElement table:tables) {
			if(table.isDisplayed()) {
				driver.executeScript("arguments[0].style.border='2px dotted boarder';", table);
			}
		}
		//collect each row in table
		for(WebElement table:tables) {
		List<WebElement> rows=table.findElements(By.xpath("child::tr"));
		System.out.println("count of rows is "+rows.size());
		System.out.println("----------------------");
		
		//collect  cols in each row
		for(WebElement row:rows) {
			List<WebElement> cols=row.findElements(By.xpath("child::td"));
			System.out.print("count of all cols is "+cols.size());
			
			//display cols values
			for(WebElement col:cols) {
				System.out.print(col.getText()+",");
			}
			System.out.println("-----------");
		}

		}

	}

}
