package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test99 
{
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site(operation)
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//Locate an Element
		WebElement e=driver.findElement(By.linkText("Gmail"));
		//get details before focus
		String x=e.getCssValue("text-decoration");
		System.out.println(x);
		//get Focus
		Actions act=new Actions(driver);
		act.moveToElement(e).perform();
		Thread.sleep(5000);
		//get details after focus
		String y=e.getCssValue("text-decoration");
		System.out.println(y);
		if(y.contains("underline"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failde due to  no underline");
		}
		
	
	//close site
	driver.close();
	}
}
