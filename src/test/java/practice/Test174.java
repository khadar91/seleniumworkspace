package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test174 {

	public static void main(String[] args) {
		// open Browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
				FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(20));
				wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("http://www.gmail.com");
		ExpectedCondition<Boolean> ec1=titleIs("Gmail");
		ExpectedCondition<Boolean> ec2=urlContains("https");
		wait.until(and(ec1,ec2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")))
		                                                                                 .sendKeys("magnitiait");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/parent::button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd"))).sendKeys("44@Magnitia");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/parent::button"))).click();
		//close driver
		driver.close();
	}

}
