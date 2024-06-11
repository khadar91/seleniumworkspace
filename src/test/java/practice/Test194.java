package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test194 {
	@Test
	public void method() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//define wait  object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("http://www.google.co.in");
		//Locate an Element via visual relations with other element in page
		WebElement e1=driver.findElement(By.xpath("(//form[@role='search']//*[name()='svg'])[1]")); //search
		WebElement e2=driver.findElement(By.xpath("//div[@aria-label='Search by voice']//*[name()='svg']")); //Mic
		RelativeBy rby=RelativeLocator.with(By.xpath("//div"));
		List<WebElement> targets=driver.findElements(rby.toRightOf(e1).toLeftOf(e2));
		System.out.println(targets.size());
		for(WebElement target:targets)
		{
			driver.executeScript("arguments[0].style.border='2px solid blue';", target);
			Thread.sleep(5000);
		}
		
		
		
		
		
	}

}
