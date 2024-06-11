package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test78 {
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open Browser
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
	public void method2() 
	{
	System.out.println("Cookie site after Launching::");
	System.out.println("------------------------------");
	//create object on CookiesUtility class
	obj=new CookiesUtility();
	System.out.println(obj.getCookiesCount(driver));
	System.out.println(obj.getCookiesList(driver));
	List<String> types1=obj.getTypeOfCookies(driver, "google.co.in", "google.co.in");
	for(String type:types1)
	{
		System.out.println(type);
	}
	}
	@Test(priority=3)
	public void method3() 
	{
		//Dop search
		driver.findElement(By.name("q")).sendKeys("abdul kalam");
		System.out.println("cookies site after seraching");
		System.out.println("-----------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));;
		List<String> types2 =obj.getTypeOfCookies(driver, "google.co.in", "google.co.in");
		for(String type:types2)
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
