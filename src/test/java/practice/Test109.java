package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test109 {
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
		//Launch site
		driver.get("https://www.google.co.in");
		          
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//after Launching collect list of all elements in page
		List<WebElement> l=driver.findElements(By.xpath("//*")); // all elements
		Thread.sleep(5000);
		//check each element
		int vec=0;
		int hec=0;
		for(WebElement e:l) 
		{
			if(e.isDisplayed())
			{
				vec++;
			}
			else
			{
				hec++;
			}
		}
		System.out.println("Visible element count:"+vec);
		System.out.println("Hidden element count:"+hec);
	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();

	}
}

