package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test92 {
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
	driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
	Thread.sleep(5000); 
	//"ElementNotInteractableException" because we try to fill a disabled element
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.name("lname")).sendKeys("abdulkalam");
}

}
