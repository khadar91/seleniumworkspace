package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test65 {

	public static void main(String[] args)throws Exception
	{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("https://www.spicejet.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text()='From']/following::input[1]")).clear();
		driver.findElement(By.xpath("//div[text()='From'/following::input[1]")).sendKeys("Bengaluru(BLR)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text='To']/following::input[1]")).clear();
		driver.findElement(By.xpath("//div[text='To']/following::input[1]")).sendKeys("Delhi(DEL)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='23'])[1]")).click(); //date
		Thread.sleep(5000);
		
		
		
	}

}
