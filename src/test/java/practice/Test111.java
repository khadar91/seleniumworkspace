package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test111 {
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
		//Locate an visible element,which is enabled or disabled or
		// covered by another element like banner in page
		//we will get correct output
		WebElement e=driver.findElement(By.name("q"));
		//Get width and height,x & y coordinates
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		System.out.println(w+"  "+h);
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		System.out.println(x+"  "+y);
		int w1=e.getRect().getWidth();
		int h1=e.getRect().getHeight();
		int x1=e.getRect().getX();
		int y1=e.getRect().getY();
		System.out.println(w1+"   "+h1+" "+x1+"  "+y1);

	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();
	}
}