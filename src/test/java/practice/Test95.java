package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test95 {
	RemoteWebDriver driver;
	
	@Test(priority=1)
		public void mthod1() throws Exception
		{
			//open browser
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//maximize the browser
			driver.manage().window().maximize();
			Thread.sleep(5000); 
			//launch site 
			driver.get("http://www.gmail.com");
			Thread.sleep(5000);
			//  "ElementNotInteractableException" due to clear on hidden Element
			driver.findElement(By.name("hiddenPassword")).clear();
		}

}
