package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test79 
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the brpwser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://yahoomail.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2()
	{
		System.out.println("Cookies after launchin Site::");
		System.out.println("------------------------------");
		obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types1=obj.getTypeOfCookies(driver, "yahoomail.com", "yahoomail.com");
		for(String type:types1)
		{
			System.out.println(type);
		}
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
		driver.findElement(By.linkText("Sign in")).click(); 
		Thread.sleep(5000);
		driver.findElement(By.id("login-username")).sendKeys("sampleprogram");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("sampleprogram");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		System.out.println("Cookies after Login to site");
		System.out.println("---------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types2=obj.getTypeOfCookies(driver, "yahoomail.com", "yahoomail.com");
		for(String type:types2)
		{
			System.out.println(type);
		}
	} 
	@Test(priority=4)
	public void method4() throws Exception
	{
		//Do Logout
		driver.findElement(By.id("ybarAccountMenuOpener")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("profile-signout-link")).click();
		Thread.sleep(5000);
		System.out.println("Cookies after Logout frm site::");
		System.out.println("--------------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types3=obj.getTypeOfCookies(driver, "yahoomail.com", "yahoomail.com");
		for(String type:types3)
		{
			
			System.out.println(type);
			
		}			
	}
	@Test(priority=5)
	public void method5()
	{
		//close site
		driver.close();
	}
}
