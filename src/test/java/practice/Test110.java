package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test110 {
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
		driver.get("https://www.semantic-ui.com/modules/checkbox.html");
		          
		Thread.sleep(5000);
	
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//after Launching collect list of all elements in page
		List<WebElement> l=driver.findElements(By.xpath("//input[@type='checkbox']")); // all elements
		Thread.sleep(5000);
		//check each element
		int x=0;
		int y=0;
		for(WebElement e:l) 
		{
			if(e.isSelected())
			{
				x++;
			}
			else
			{
				y++;
			}
		}
		System.out.println("selected check boxes count is:"+x);
		System.out.println("deselected check boxes count is:"+y);
	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();

	}
}
