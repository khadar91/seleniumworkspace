package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test21 {

	public static void main(String[] args) throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//open site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		//switch to frame by using frame name/id
		driver.switchTo().frame("iframeResult");
		//fill fields
		driver.findElement(By.name("fname")).clear(); // removing existing values
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

}
