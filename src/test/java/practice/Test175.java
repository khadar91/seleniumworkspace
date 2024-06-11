package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test175 {

	public static void main(String[] args) {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//define wait object                                         
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		driver.manage().window().maximize();
		//launch site
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'RadCalendar')]")));
		//get claender into top of the DESKTOP
		WebElement e=driver.findElement(By.xpath("//div[contains(@class,'RadCalendar')]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		//wait,locate and click on a day link
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("22"))).click();
		//Define wait condition for invisibility of loader(spinner) icon to press f8 and debugging
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		//close driver
		driver.close();

	}

}
