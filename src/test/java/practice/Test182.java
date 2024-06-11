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

public class Test182 {

	public static void main(String[] args)throws Exception {
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		//if banner exist close the banner
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']"))).click();
		}
		catch(Exception ex)
		{
			System.out.println("no banner exist");
		}
		//Locate an Element
		ActionsUtility obj=new ActionsUtility(driver, wait);
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Fashion']")));
		obj.focusOnElementCenter(e1);
		Thread.sleep(5000);
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women Footwear")));
		obj.focusOnElementCenter(e2);
		Thread.sleep(5000);
		WebElement e3=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women Wedges")));
		obj.focusOnElementCenter(e3);
		
		
	}

}
