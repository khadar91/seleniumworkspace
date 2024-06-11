package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test98 {
	RemoteWebDriver driver;
	@Test
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		//use getAttribute to get HTML attribute value
		//1. null will come when spelling of HTML attribute name is wrong in our automation code
		//2.null will come when no given HTML attribute in Element source
		//3.null will come when no value  given HTML attribute in Element source
		//4.if all are correct value will come
		//5. no chance for any Exception on getAttribute() ,method\
		String x=e.getAttribute("type");//"type" is HTML Attribute
		System.out.println(x);
		//use getCssValue() to get CSS attribute value
		//1.blank will come CSS attribute name spelling is wrong in out automation code
		//2.blank will come when no given CSS attribute in Element source
		//3.blank will come when no value to given CSS attribute in element source
		//4.if all are correct ,value will come
		//5.no chance for any Exception in getCssValue() method
		String y=e.getCssValue("color");// "color" is CSSproperty
		System.out.println(y);
		//close site
		driver.close();
		
		
	}

}
