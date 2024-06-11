package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test89 {
	RemoteWebDriver driver;
	@Test
public void method1() throws Exception
{
	//open browser
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//maximize the browser
	driver.manage().window().maximize();
	Thread.sleep(5000);
	//Launch site
	driver.get("http://www.facebook.com");
	Thread.sleep(5000); 
	//fill user id field
	driver.findElement(By.name("email")).sendKeys("abdulkalam");
	Thread.sleep(5000);
	//fill password and click sign-in button via keyboard automation
	driver.findElement(By.name("pass")).sendKeys("kalam",Keys.TAB,Keys.TAB,Keys.ENTER);
}
	
	

}
