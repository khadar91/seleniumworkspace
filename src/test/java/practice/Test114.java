package practice;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test114 {
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
		driver.get("https://www.gmail.com");

		Thread.sleep(5000);

	}
	@Test(priority=2)
	public void method2() throws Exception
	{
	//get locate an hidden element in page
		WebElement e=driver.findElement(By.name("hiddenPassword"));
		//Get Screenshot of that element(Way-1)
		File src=e.getScreenshotAs(OutputType.FILE);
		File dest=new File("target//hiddenelementpic.png");
		FileHandler.copy(src, dest);
		//get blank screenshot of hidden element in page source
		
	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();
	}
	
}