package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test12 {

	public static void main(String[] args)throws Exception {
		// download chrome driver software
		WebDriverManager.chromedriver().setup();
		//open chrome driver software
		RemoteWebDriver driver=new ChromeDriver();
		// lunchih site
	/*	driver.get("http://www.sentia.in/");// base url
		Thread.sleep(5000);
		//get source code of the page
		String x=driver.getPageSource();
		System.out.println(x);*/
		driver.get("https://www.shopifymart.co/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='head-home']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='head-all']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='head-types']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='category-popover'])//div[3]")).click();
		Thread.sleep(5000);
		
		//close site
		driver.close();
		

	}

}
