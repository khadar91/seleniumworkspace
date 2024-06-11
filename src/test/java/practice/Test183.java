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

public class Test183 {

	public static void main(String[] args) throws Exception {
		// open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		driver.get("http://www.google.co.in");
		ActionsUtility obj=new ActionsUtility(driver, wait);
		//move to element
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
		obj.focusOnElementCenter(e1);
		Thread.sleep(5000);
		//right click on Element
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		obj.rightClickOnElement(e2);
		Thread.sleep(5000);
		//Double Click an Element
		WebElement e3=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail")));
		obj.doubleClickOnElement(e3);
		
		

	}

}
