package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test101 {
	RemoteWebDriver driver;
	
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000); 
		
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//Locate the Elemengt
		WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		//before right click
		String x1=e.getCssValue("color");
		System.out.println(x1);
		String x2=e.getCssValue("background-color");
		System.out.println(x2);
		Actions act=new Actions(driver);
		act.contextClick(e).perform();
		Thread.sleep(5000);
		//after Right Click
		String y1=e.getCssValue("color");
		System.out.println(y1);
		//get background color
		String y2=e.getCssValue("background-color");
		System.out.println(y2);
		if(!x1.equals(x2)&& !y1.equals(y2))
		{
			System.out.println("Test passed because of changer after right click");
		}
		else
		{
			System.out.println("Test failed due to same after right click");
		}
		//close site
		driver.close(); 
	}

}
