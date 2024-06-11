package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Test208 {

	public static void main(String[] args) throws Exception{
		//page scrolling
		//(scroll Top to Bottom, Bottom to Top, Left to right,Right to Left and to specific element)
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		//change browser window size to get scroll bars
		Dimension d=new Dimension(500,400); //width and hight
		driver.manage().window().setSize(d);
		//Scroll down
		//driver.executeScript("window.scrollTo(0,document.body.scrollHieght);");
		driver.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//scroll up
		//driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		driver.executeScript("window.scrollBy(0,(-document.body.scrollHeight));");
		Thread.sleep(5000);
		//scroll right
		driver.executeScript("window.scrollBy(document.body.scrollWidth,0);");
		Thread.sleep(5000);
		//scroll right
		driver.executeScript("window.scrollBy(-(document.body.scrollWidth),0);");
		//Scroll to specific element in page
		WebElement e=driver.findElement(By.id("email"));
		driver.executeScript("arguments[0]. scrollIntoView();",e);
		Thread.sleep(5000);
		//Close site
		driver.close();
		

	}

}
