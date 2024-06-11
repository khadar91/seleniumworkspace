package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.ActionsUtility;

public class Test187 {

	public static void main(String[] args) throws Exception{
		// open browser 
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define  wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("https://jqueryui.com/slider");
		//HoriZontel slider
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//way-1
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.id("slider")));
		//way-2
		//WebElement e1=driver.findElement(By.id("slider"));
		ActionsUtility obj=new ActionsUtility(driver, wait);
		obj.clickOnElementLocation(e1, 100, 0); // Left to Right
		Thread.sleep(5000);
		obj.clickOnElementLocation(e1, -100, 0); //Right to Left
		driver.switchTo().defaultContent();
		//vertical Slider
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vertical slider"))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.id("slider-vertical")));
		obj.clickOnElementLocation(e2, 	0, 100); // top to bottom
		Thread.sleep(5000);
		obj.clickOnElementLocation(e2, 0, -100); // bottom to top
		driver.switchTo().defaultContent();
		
		

	}

}
