package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Test188Propblem {

	public static void main(String[] args) throws Exception {
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://codepen.io/rjsmer/full/vvewWp");
		Thread.sleep(5000);
		driver.switchTo().frame(0); //outer Frame
		driver.switchTo().frame(0); //inner 1st Frame
	WebElement drag=driver.findElement(By.id("dragFrame-0"));
	driver.switchTo().parentFrame(); //back to outer page
	driver.switchTo().frame(1); // 2nd frame in page
	WebElement drop=driver.findElement(By.id("element2-1"));
	Actions act=new Actions(driver);
	act.dragAndDrop(drag, drop).perform(); //StaleElementReferenceException
		

	}

}
