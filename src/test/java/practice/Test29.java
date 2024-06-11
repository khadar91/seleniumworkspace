package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test29 {

	public static void main(String[] args) {
		// download latest chromedriver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://chercher.tech/practice/frames");
		//switch to frame
		driver.switchTo().frame(0);//1st frame
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("abdullkalam");
		//select check box inner frame
		driver.switchTo().frame(0);// switch to inner frame
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//back to page directly from inner frame
		driver.switchTo().defaultContent();
		//
		
		

	}

}
