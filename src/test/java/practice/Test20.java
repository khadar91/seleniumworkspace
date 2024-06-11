package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test20 {

	public static void main(String[] args) throws Exception
	{
		//open chrome driver
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("asffdp");
		driver.findElement(By.id("pass")).sendKeys("rhdud");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='u_0_5_a3']")).click();

	}

}
