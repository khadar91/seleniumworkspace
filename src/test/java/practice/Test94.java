package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test94 {
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
	driver.get("https://www.gmail.com");
	Thread.sleep(5000); 
	driver.findElement(By.name("identifier")).sendKeys("abdulkalam");
	Thread.sleep(5000);
	//clear data in element
	driver.findElement(By.name("identifier")).clear();
}

}
