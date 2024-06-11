package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test100 {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1()throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//locate an Element
		WebElement e=driver.findElement(By.xpath("//div[@jsname='RNNXgb']"));
		//get details before focus
		String x=e.getCssValue("box-shadow");// no shadow
		System.out.println(x);
		//get focus
		Actions act=new Actions(driver);
		act.moveToElement(e).perform();
		Thread.sleep(5000);
		//get details after focus
		String y=e.getCssValue("box-shadow"); //shadow exists
		System.out.println(y);
		if(!y.contains("none"))
		{
			System.out.println("Test passed because of shading");
		}
		else
		{
			System.out.println("Test failed due to no shading");
		}
		//close site
		driver.close();
	}

}
