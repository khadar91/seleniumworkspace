package practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CookiesUtility;

public class Test82 
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	List<String> c1;

	@Test(priority=1)
	public void method1() throws Exception{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.google.com");
	}
	@Test(priority=2)
	public void method2() 
	{
		//create any type of cookie(7 types) and add the current webdriver's cookie(way-1)
		String cookieName="session-id";
		String cookieValue="12345";
		String domain="google.com";
		String path="/";
		Date expiryDate=null;
		boolean isSecure=false;
		boolean isHttpOnly=true;
		String sameSite="Lax";
		obj=new CookiesUtility();
		obj.addNewCookie(driver, cookieName, cookieValue, domain, path, expiryDate, 
				isSecure, isHttpOnly, sameSite);
	}
	@Test(priority=3)
	public void method3() 
	{
		System.out.println("Count of Cookies is ::"+obj.getCookiesCount(driver));
		//collect all loaded cookies along with added cookie
		c1=obj.getCookiesList(driver);
		for(String c:c1)
		{
			System.out.println(c);
		}

	}
	@Test(priority=4)
	public void method4()
	{
		//get specific cookie using cookies name
		Cookie c=driver.manage().getCookieNamed("session-id");
		System.out.println(c.getName()+"------------"+c.getValue()+"----"+c.getDomain());
		//Delete specific cookie using cookie classes's object
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		driver.manage().deleteCookie(l.get(1)); //2nd cookie in list
		//Delete Specifi cookie with name
		driver.manage().deleteCookieNamed("session-id");
		//Delete All cookies
		driver.manage().deleteAllCookies();
		//close site
		driver.close();



	}




}

