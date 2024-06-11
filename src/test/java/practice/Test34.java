package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test34 {

	public static void main(String[] args) throws Exception 
	{
	//download latest chrome browser software
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	//launch site
	driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
	//switch to frame
	driver.switchTo().frame("pact");
	WebElement ShadowHostRootElement=driver.findElement(By.id("snacktime"));
	SearchContext ShadowRootElement=ShadowHostRootElement.getShadowRoot();
	WebElement TargetElement=ShadowRootElement.findElement(By.className("food"));
	try {
		TargetElement.click();
		Thread.sleep(5000);
	}
	catch(JavascriptException e){
		driver.executeScript("arguments[0].click();", TargetElement);
		Thread.sleep(5000);
	}
	//switch to new window/tab
	Set <String> s=driver.getWindowHandles();
	List<String> l=new ArrayList<String>(s);
	driver.switchTo().window(l.get(1));
	driver.findElement(By.xpath("//li[@id='menu-item-48']/a")).click();
	
	
	

	}

}
