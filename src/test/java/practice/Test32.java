package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test32 {

	public static void main(String[] args) throws Exception
	{
		// to download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//to lauch site
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		//enete to frame
		driver.switchTo().frame("pact");
		//elemente under shadowroot se we have to
		WebElement shadowHostElement=driver.findElement(By.id("snacktime"));
		SearchContext shadowRootElement=shadowHostElement.getShadowRoot();
		WebElement targetElement=shadowRootElement.findElement(By.className("food"));
		try {
			targetElement.click();
		}
		catch(JavascriptException ex) {
			driver.executeScript("arguments[0].click();",targetElement);
			
		}
	

	}

}
