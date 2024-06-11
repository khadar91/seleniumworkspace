package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test207 {

	public static void main(String[] args) throws Exception{
		//page scrolling
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		//locate and move to an element at end of the page
		WebElement e1=driver.findElement(By.linkText("Contact Us"));
		act.moveToElement(e1).perform();
		driver.executeScript("arguments[0].style.border='2px solid red';", e1);
		Thread.sleep(5000);
		//locate and move to an element at top of the page
		WebElement e2=driver.findElement(By.partialLinkText("Ask Question"));
		act.moveToElement(e2).perform();
		driver.executeScript("arguments[0].style.border='2px solid red';", e2);

	}

}
