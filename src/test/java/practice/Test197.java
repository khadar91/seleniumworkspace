package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test197 {

	@Test
	public void method()
	{
		//open brower
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("http://www.google.co.in");
		//way-1: Locate and operate  Element using javaScript
		driver.executeScript("document.getElementsByName('q')[0].value='abdul kalam';");
		//Way-2:Locate an Element using Selenium and Operate Element using java script
		WebElement e=driver.findElement(By.name("btnK"));
		driver.executeScript("arguments[0].click()", e);

	}
}
