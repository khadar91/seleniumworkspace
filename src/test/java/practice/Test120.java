package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test120 {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
				driver.get("https://books-pwakit.appspot.com");
				Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws  Exception 
	{
		//Element under a single shadow DOM
		driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")) //Goto shadow host
		           .getShadowRoot() //Goto shadow root
		           .findElement(By.id("input")).sendKeys("abdulkalam"); //goto target Element
		
	}

}
