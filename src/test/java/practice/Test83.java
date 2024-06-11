package practice;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test83
{
	RemoteWebDriver driver;
	CookiesUtility obj;
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
		driver.get("https://www.youtube.com");
		Thread.sleep(5000);
	}
	@Test(priority=2) 
	public void method2()
	{
		obj=new CookiesUtility();
		//create any type of Cookies(7types) using CookieBuilder(way-2)
		Date today=new Date();
		Date tomarrow=new Date(today.getTime()+(3000));
		obj.addNewCookieViaBuilder(driver, "session-id-time", "magnitia", "www.youtube.com", "/",
				                                                tomarrow, true, false, "Strict");
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
		//collect all cookies
		List<String> cl1=obj.getCookiesList(driver);
		for(String c:cl1)
		{
			System.out.println(c);
		}
		Thread.sleep(5000); //waiting 
		//collect all cookies after waiting
		List<String> cl2=obj.getCookiesList(driver);
		for(String c:cl2)
		{
			System.out.println(c);
		}
		
	}
	@Test(priority=4)
	public void method4()
	{
		//close site
		driver.close();
			
		}
		
		
	}


		