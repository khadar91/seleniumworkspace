package tests;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesTest1 {
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void method1() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	 public void mehod2()
	 {
		System.out.println("Cookies after launching site::");
		System.out.println("-------------------------------");
	obj=new	CookiesUtility();
	System.out.println(obj.getCookiesCount(driver));
	System.out.println(obj.getCookisList(driver));
	List<String> types=obj.getCookieTypes(driver, "facebook.com", "facebook.com");
	for(String type:types)
	{
		System.out.println("----------"+type);
	}
	 }
	@Test(priority=3)
	public void method3() {
		//close the site
		driver.close();
	}
		 
	 }




