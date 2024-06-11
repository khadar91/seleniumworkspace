package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test124 {
	RemoteWebDriver driver;
	@Test
	public void method1() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		try
		{
		driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("no banner for this time");
		}
		//Click  on "mobiles" link
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(5000);
		//click on "shop now" 
		driver.findElement(By.xpath("//p[text()='Realme']")).click();
		Thread.sleep(5000);
		//pagination
		while(true)
		{
			//goto next page if exist
			try
			{
				
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		}
			catch(Exception e)
			{
		break;// terminate from loop
		}
			}
		//close the banner
		//driver.close();
	}
	}

