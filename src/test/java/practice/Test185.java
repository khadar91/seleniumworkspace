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

public class Test185 {

	public static void main(String[] args) {
		// open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//define Object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");	
		//Way-1
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		//WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		//way-2
		
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		ActionsUtility obj=new ActionsUtility(driver, wait);
		obj.dragDrop(driver, e1, e2);
		driver.switchTo().defaultContent();
		
		
		
		

	}

}
