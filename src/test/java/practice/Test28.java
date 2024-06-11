package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test28 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://chercher.tech/practice/frames");
		//switch to frame
		driver.switchTo().frame(0);//1st frame
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("abdullkalam");
		driver.switchTo().defaultContent();

	}

}
