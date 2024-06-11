package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test121 {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//Open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximize the Browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//Launch site
		driver.get("chrome://settings/");
		Thread.sleep(5000);
		//This element inside of nested shadow DOM
		driver.findElement(By.tagName("settings-ui")) //GOTO Shadow Host
		       .getShadowRoot()//goto shadow root
		       .findElement(By.id("toolbar")) //Goto shadow host
		       .getShadowRoot()//goto shadow root
		       .findElement(By.id("search")) //goto shadow host
		       .getShadowRoot()//goto shadow root
		       .findElement(By.id("searchInput")).sendKeys("abdulkalam"); //goto target element
		       
	}

}
