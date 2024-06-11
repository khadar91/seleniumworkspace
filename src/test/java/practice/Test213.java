package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test213 {

	public static void main(String[] args) throws Exception {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//search a word
		driver.executeScript("window.alert('Site is Ready to launch');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.get("http://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("abdul kalam",Keys.ENTER);
		//close site alert
		driver.executeScript("window.alert('site is goining to be close');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.close();
	}

}
