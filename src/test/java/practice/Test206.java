package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test206 {

	public static void main(String[] args) throws Exception{
		// page scrolling(top to bottom and bottom to top)
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//page scrolling
		Actions act=new Actions(driver);
		act.sendKeys(Keys.END).perform(); //top to bottom
		Thread.sleep(5000);
		act.sendKeys(Keys.HOME).perform();
		Thread.sleep(5000);
		

	}

}
