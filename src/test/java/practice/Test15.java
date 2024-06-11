package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test15 {

	public static void main(String[] args) throws Exception {
		// downlaod chrome driver software
		WebDriverManager.chromedriver().setup();
		//open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.w3schools.com");//base url
		
		Thread.sleep(5000);
		//click on button
		driver.findElement(By.linkText("Try it Yourself")).click();
	
		Thread.sleep(5000);
		//close all tabs
		driver.quit();

	}

}
