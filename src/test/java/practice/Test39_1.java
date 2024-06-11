package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test39_1 {

	public static void main(String[] args)throws Exception
	{
		// to download chromedriver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch fastmail site
				driver.get("http://www.fastmail.com");
				//do Login fiels
				driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//form[@id=\"v9\"]/child::div/div/div/input[@id='v30-input']")).sendKeys("sampleprogram12");
				driver.findElement(By.name("password")).sendKeys("vallikhadar15");
				//click login button
				driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
				Thread.sleep(5000);
		//fill text fields
		driver.findElement(By.xpath("//label[text()='To']/following::div[1]")).sendKeys("saampleprogram12@yahoo.com");
		driver.findElement(By.xpath("//label[text()='Subject']/following::div[1]")).sendKeys("test data");
		
		

	}
   
}
