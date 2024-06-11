package tests;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeys {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in");
	WebElement e=driver.findElement(By.name("q"));
	//e.sendKeys("abdul kalam");
	//driver.executeScript("arguments[0].value='abdul kalam';",e);
	//driver.executeScript("document.getElementsByName('q')[0].value='thomas kutty';");
	Actions act=new Actions(driver);
	act.sendKeys(e,"khadar").perform();
}
}
