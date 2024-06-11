package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeOut_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		Duration d=driver.manage().timeouts().getScriptTimeout();
		System.out.println(d.getSeconds());// 30 seconds
		driver.manage().timeouts().setScriptTimeout(Duration.ofMillis(8));
		driver.get("https://www.gmail.com");
		WebElement e=driver.findElement(By.name("identifier"));
		driver.executeScript("arguments[0].style.border='5px solid red';", e);

	}

}
