package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test102B {
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
		driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_before");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2()
	{
		//after Launching site
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		//Loacte an Element
		WebElement e=driver.findElement(By.xpath("//h1[text()='This is a heading'][1]"));
		String x=(String)driver.executeScript(
				"var ps=window.getComputedStyle(arguments[0],'::before');"+
				 "var s=ps.getPropertyValue('content');"+
				 "return (s);",e);
		System.out.println(x);
		driver.switchTo().defaultContent();
		//close the site
		driver.close();
		
	}  
	

}
