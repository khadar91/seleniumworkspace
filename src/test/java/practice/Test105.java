package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test105 {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(5000);
	
	}
	@Test(priority=2)
	public void method2()
	{
		// 5.Get text of parent element along with text of all child elements)
		//using getText() (it is better way when child element is dynamic)
		WebElement e=driver.findElement(By.xpath("//span[@rel='current_population']"));
		String x=e.getText();
		System.out.println(x);
		// 6.locate parent, but but get text of specific child element(8th child) using java script
		String y=(String)driver.executeScript("return(arguments[0].childNodes[7].textContent)", e);
		System.out.println(y);
		//if we have parent element text only if exists ,we use 0 as index in above code

		//close the site
		driver.close();
	}

}
