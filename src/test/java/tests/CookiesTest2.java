package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesTest2 {
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void method1() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2()
	{
		System.out.println("Cookies After launching site::");
	System.out.println("==========================================================");
		obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookisList(driver));
		List<String> types=obj.getCookieTypes(driver, "google.co.in", "google.co.in");
		for(String type:types)
		{
			System.out.println(type);
		}
	}
	@Test(priority=3)
	public void method3()
	{
	driver.findElement(By.name("q")).sendKeys("abdul kalam");
	System.out.println("After searching a word");
	obj=new CookiesUtility();
	System.out.println(obj.getCookiesCount(driver));
	System.out.println(obj.getCookisList(driver));
	List<String> types=obj.getCookieTypes(driver, "google.co.in", "google.co.in");
	for(String type:types)
	{
		System.out.println(type);
	}
	}
	@Test(priority=4)
	public void method4() 
	{
		//close the driver
		driver.close();
		
}
}
