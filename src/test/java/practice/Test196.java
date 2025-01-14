package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test196 {
	@Test
	public void method()
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("http://www.gmail.com");
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='to continue to Gmail']")));
		WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Forgot email?']")));
		WebElement target=wait.until(ExpectedConditions.visibilityOfElementLocated(RelativeLocator.with(By.tagName("input")).below(e1).above(e2)));
		target.sendKeys("magnitia");
		
	}

}
