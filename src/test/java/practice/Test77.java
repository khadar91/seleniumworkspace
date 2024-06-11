package practice;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test77 
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//launch site
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
	}
	@Test
	public void method2() 
	{
		System.out.println("Cookies after Launchindg site:");
		System.out.println("-------------------------------");
		obj=new CookiesUtility();
	System.out.println(obj.getCookiesCount(driver));
	System.out.println(obj.getCookiesList(driver));
		List<String> types=obj.getTypeOfCookies(driver, "facebook.com", "facebook.com");
		for(String type:types)
		{
		System.out.println(type);
	}
	}
	@Test
	public void method3() {
		//close the site
		driver.close();
	}

	}
