package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test112 {
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
	//get hidden element in page
		WebElement e=driver.findElement(By.name("hiddenPassword"));
		//Get Size info
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		System.out.println(w+"  "+h); //as per source code, no exception
		//get Location info
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		System.out.println(x+"  "+y); //0 and 0 for hidden element, no Exception
		//get rect info
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