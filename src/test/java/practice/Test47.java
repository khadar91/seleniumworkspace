package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test47 {

	public static void main(String[] args)throws Exception {
		// to download latest chrome browser software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/points-table-standings");
		Thread.sleep(5000);
		//collectr all tables from page sources
		List<WebElement> tables=driver.findElements(By.xpath("//table/tbody"));
		System.out.println("All tables count is: "+tables.size());
		//collect each table row from the list
		for(int i=0;i<tables.size();i++) {
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody[+i+]/tr"));
			System.out.println(rows.size()+"Rows in atable"+i);
			System.out.println("------------------------------");
			//collect each colums in row
		for(int j=0;j<=rows.size();j++) {
			List<WebElement> cols=driver.findElements(By.xpath("//table/tbody[+i+]/tr[+j+]/td"));
			System.out.println(cols.size()+"coolums in tables"+j);
			System.out.println("-------------------------------");
			//get each colums get value 
		for(int k=0;k<=cols.size();k++) {
			System.out.print(driver.findElement(By.xpath("//table/tbody/[+i+]/tr/[+j+]/td/[+k+]")).getText()+" , "); 
		}
		System.out.println();
		}
			driver.close();
			
		}
		
	}

}
