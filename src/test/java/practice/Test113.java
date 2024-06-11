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

public class Test113 {
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
		driver.get("https://www.google.com");

		Thread.sleep(5000);

	}
	@Test(priority=2)
	public void method2() throws Exception
	{
	//get locate an element visible in page
		WebElement e=driver.findElement(By.xpath("//img[@alt='Google']"));
		//Get Screenshot of that element(Way-1)
		File src=e.getScreenshotAs(OutputType.FILE);
		File dest=new File("target//myelement.png");
		FileHandler.copy(src, dest);
		//Way-2 :as Base64 string
		String src2=e.getScreenshotAs(OutputType.BASE64);
		System.out.println(src2);
		//WAY-3:AS BYTES
		byte[] src3=e.getScreenshotAs(OutputType.BYTES);
		//use src3 array n cucumber reports
	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();
	}
	
}