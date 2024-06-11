package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test179 {

	public static void main(String[] args) {
		// open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		driver.get("http://www.gmail.com");
		//Locate and operate an element
		WebElement e=wait.until(visibilityOfElementLocated(By.name("identifier")));
		e.sendKeys("magnitiait");
		//goto next page(new DOM/page-source)
		wait.until(elementToBeClickable(By.xpath("//span[text()='Next']/parent::button"))).click();
		wait.until(visibilityOfElementLocated(By.xpath("//a[@aria-label='Try again']")));
		//back to previous page (back to previous DOM/page source)
		driver.navigate().back();
		//Relocate element if that element is staled
		if(wait.until(stalenessOf(e)))
		{
			e=wait.until(visibilityOfElementLocated(By.name("identifier")));
		}
		e.clear();
		e.sendKeys("abdulkalam");
		

	}

}
