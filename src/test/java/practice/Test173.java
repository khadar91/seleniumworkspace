package practice;

import java.time.Duration;
import java.util.function.Function;

import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import  static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test173 {

	public static void main(String[] args) throws Exception {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Define FluentWait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("http://dev.worke.io/register");
		wait.until(urlContains("https"));
		//fill the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")))
		                                                                               .sendKeys("abdul");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")))
		                                                                               .sendKeys("kalam");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usermail")))
		                                                                             .sendKeys("apj@abdulkalam.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")))
		                                                                                .sendKeys("9875433245");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")))
		                                                                               .sendKeys("batch261");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Business Name']")))
		                                                                                       .sendKeys("teaching.worke.io");

		wait.until(elementToBeClickable(
				By.xpath("//button[text()='Register']"))).click();
		
	}

	

}
