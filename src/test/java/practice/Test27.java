package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test27 {
	public static void main(String[] args) throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame using object of WebElement
		WebElement f=driver.findElement(By.xpath("//div[@id='iframe']/descendant::iframe"));
		driver.switchTo().frame(f);
		//fill fields
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
		//back to page
		driver.switchTo().defaultContent();
		//close the site

	}

}
