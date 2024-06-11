package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test209 {

	public static void main(String[] args) throws Exception {
		// Element scroll
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		//locate an element down in scroll down
		WebElement e=driver.findElement(By.xpath("(//pre[contains(@class,'lang-java')])[1]"));
		act.sendKeys(e,Keys.END).perform();
		Thread.sleep(5000);
		//Element Up
		act.sendKeys(e,Keys.HOME).perform();
		Thread.sleep(5000);

	}

}
