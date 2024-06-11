package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test198 {
	@Test
	public void method()
	{
		//open brower
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("http://www.google.co.in");
		//way-2: locate element using SWD-java and operate that element using JavaScript
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].value='abdul kalam';", e);
        //way-1: both locate and operate element using JavaScriptt
		driver.executeScript("document.getElementsByName('btnK')[0].click();");
	}
}
