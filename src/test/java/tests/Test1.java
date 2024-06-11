package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//get gurl
		driver.get("http://www.w3schools.com");
		Thread.sleep(500);
		WebElement e=driver.findElement(By.linkText("Try it Yourself"));
		Thread.sleep(5000);
		e.click();
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		
		//get handile id of window/tab
		Set<String> s=driver.getWindowHandles();
		System.out.println(s);
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(l.get(0));
		driver.close();

	}

}
