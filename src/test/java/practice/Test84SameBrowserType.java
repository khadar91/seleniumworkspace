package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test84SameBrowserType {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.fastmail.com");
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000); 
		//locate form in x=driver.findElement(By.xpath("//form[@id='v9']"));
		driver.findElement(By.xpath("//input[@id='v18-input']")).sendKeys("sampleprogram");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("seleniumpractise");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
	}
/* @Test(priority=3)
	public void method3() throws Exception
	{
		//take new window/tab in chrome and switch to that new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh=driver.getWindowHandles();
		List<String> lwh=new ArrayList<String>(swh);
		driver.switchTo().window(lwh.get(1));
		//Launch same site by skipping login due to session cookie
		driver.get("https://www.fastmail.com");
		Thread.sleep(5000);
		try {
			if(driver.findElement(By.xpath("//div[text()='Settings']")).isDisplayed());
			{
				System.out.println("Login Session cookie is  working correctly");
			}
		}
			catch(Exception ex)
			{
				System.out.println("Login Session cookie is working not correctly");
				
			}
		}
	@Test(priority=4) 
	public void method4()
	{
		//close all browser window/tabs
		driver.quit();
	}*/ 

}
