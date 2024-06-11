package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test19 {

	public static void main(String[] args) {
		//open chrome driver software
		WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	//launch site
	driver.get("chrome://settings/");
	//locate an element
	driver.findElement(By.tagName("settings-ui")).getShadowRoot()
	      .findElement(By.id("toolbar")).getShadowRoot()
	      .findElement(By.id("search")).getShadowRoot()
	      .findElement(By.id("searchInput")).sendKeys("khadar");

	}

}
