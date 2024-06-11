package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test106 {
	RemoteWebDriver driver;
	@Test
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2()
	{
		//Locate the element
		WebElement e=driver.findElement(By.name("q")); //Text box
		//Test case-1
		if(e.isDisplayed())
		{
			System.out.println("Element  is Visible in  Page");
		}
		else
		{
			System.out.println("Element is not visible in page");
		}
		
	}
	@Test(priority=3)
	public void method3()
	{
		//close the site
		driver.close();
	}

}
