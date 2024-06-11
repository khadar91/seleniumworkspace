package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test17 {

	public static void main(String[] args) throws Exception
	{
		// open browser
		WebDriverManager.chromedriver().setup();  
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//loacate an element webpage source
		driver.findElement(By.id("identifierId")).sendKeys("asdfdfzx675");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		driver.findElement(By.xpath("//div[text()=\"Couldn’t find your Google Account\"]"));
		Thread.sleep(5000);


		
		
	
			}
	}


