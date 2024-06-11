package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test108 {
	RemoteWebDriver driver;
	@Test(priority=1)  
	public void method1() throws Exception
	{
		//open the browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch the site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//switch to frame
		driver.switchTo().frame("iframeResult");
		Thread.sleep(5000);
		//Locate an element
		WebElement e=driver.findElement(By.xpath("//input[@value='HTML']"));
		Thread.sleep(5000);
		
		//Test case-1
		if(e.isDisplayed())
		{
			System.out.println("element is visible in page");
			if(e.isEnabled())
			{
				System.out.println("element is enable in page");
				//When element is radio button /check-box/drop-down(not for all)
				e.click();
				Thread.sleep(5000);
			if(e.isSelected())
			{
				System.out.println("Element is selected page in Successfully");
			}
			else
			{
				System.out.println("Element is not selected page");
			}
			}
			else 
			{
				System.out.println("Element is disabled in page");
				
			}
		}
		else
		{
			System.out.println("Element is not visable in page");
		
			}
		
			}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();
	}

}
