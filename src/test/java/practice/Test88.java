package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test88 {
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
	driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/"
			+ "explicit-show-hide/defaultcs.aspx");
	Thread.sleep(5000); 
	//challenge-3: our target element is cover by another element  like banner
	// So target element is not clickbale and we get "ElementClickIntractableException"
	driver.findElement(By.linkText("1")).click();
	
} 

}
