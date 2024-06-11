package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test93 {
	
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
	driver.get("https://www.flipkart.com");
	Thread.sleep(5000); 
	// Element covered by other element like banner but working succesfully
	driver.findElement(By.name("q")).sendKeys("mobiles");
}

}
