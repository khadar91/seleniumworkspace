package tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAndDeleteCookie {
	RemoteWebDriver driver;
	CookiesUtility obj;
	List<String> c1;
	@Test(priority=1)
	public void method1() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.google.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2()
	{
		String cookiename="session-id";
		String cookieValue="12345";
		String domain="google.com";
		String path="/";
		Date expirydate=null;
		boolean isHttpOnly=true;
		boolean isSecure=false;
		String sameSite="Lax";
		obj=new CookiesUtility();
		obj.addNewCookie(driver, cookiename, cookieValue, domain, path, expirydate, isSecure, isHttpOnly, sameSite);
		
	}
	@Test(priority=3)
public void method3()
{
	System.out.println("Count of cookies is :"+obj.getCookiesCount(driver));
	 c1=obj.getCookisList(driver);
	 for(String c:c1)
	 {
		 System.out.println(c);
	 }
}
@Test(priority=4)
public void method4()
{
	//get specific cooke using cookie named
	Cookie c=driver.manage().getCookieNamed("session-id");
	System.out.println(c.getName()+" ====" +c.getValue()+"===="+c.getDomain());
	//delete specific cookie using cookie class object
	Set<Cookie> s=driver.manage().getCookies();
	List<Cookie> l=new ArrayList<Cookie>(s);
	driver.manage().deleteCookie(l.get(1)); //2nd cookie in list
	//delete specific cookie with cooki name
	driver.manage().deleteCookieNamed("session-id");
	//delete all  cookies
	driver.manage().deleteAllCookies();
	//close site
	driver.close();
	
	
	
	
}
	
}
