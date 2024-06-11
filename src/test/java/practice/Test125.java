package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test125 {
	@Test
	public void method1() throws Exception
	{
		//open browser
		
		Thread.sleep(5000);
		RemoteWebDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//close banner if exist
		try
		{
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("no banner exist this tme");
		}
		//click on "mobiles" 
		driver.findElement(By.xpath("//span[text()='Mobiles']/parent::span")).click();
		Thread.sleep(5000);
		//click on "shop now" for 1st product
		driver.findElement(By.xpath("//p[text()='Realme']")).click();
		Thread.sleep(5000);
		//pagination
		int pno=2;
			while(true)
			{
				//goto next page if exist by clicking on page number
				try
				{
					driver.findElement(By.linkText(""+pno)).click();
					Thread.sleep(5000);
					pno++;
				}
				catch(Exception e)
				{
					break; //terminate from loop
				}
		}
			//close site
			//driver.close();
	}
}
