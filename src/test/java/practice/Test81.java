package practice;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test81 {
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void method1()throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//launch site
		driver.get("http://www.amazon.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() 
	{
		System.out.println("Cookies after Launching site::");
		System.out.println("------------------------------");
		obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types1=obj.getTypeOfCookies(driver, "amazon.in","amazon.com");
		for(String type:types1)
		{
			System.out.println(type);
		}
	}
	@Test(priority=3)
	public void method3()
	{
		//close site
		driver.close();
		
	}

}
