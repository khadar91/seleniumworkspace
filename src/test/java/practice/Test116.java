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

public class Test116 {
	RemoteWebDriver driver;
	WebElement e;
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
		driver.get("https://www.flipkart.com");

		Thread.sleep(5000);

	}
	@Test(priority=2)
	public void method2() throws Exception
	{
	//get locate Element
	  e=driver.findElement(By.xpath("//button[@type='submit']"));
		//Get Screenshot of that element covered by banner
		File src1=e.getScreenshotAs(OutputType.FILE);
		File dest1=new File("target//coveredelementpic.png");
		FileHandler.copy(src1, dest1); //banner screenshot as per  target element size
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
	//close the banner
		driver.findElement(By.xpath("//span[text()='Login'][1]/preceding::button[1]")).click();
		Thread.sleep(5000);
		//Get Screenshot of that element covered by banner
		File src2=e.getScreenshotAs(OutputType.FILE);
		File dest2=new File("target//notcoveredelementpic.png");
		FileHandler.copy(src2, dest2); //banner screenshot as per target element size
		
	}
	@Test(priority=3)
	public void method4()
	{
		//close site
		driver.close();
	}
	
}