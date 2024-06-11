package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test118 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(10000);// waiting time to load complete page
		//Locate element and get attribute value and property
		WebElement e=driver.findElement(By.name("q"));
		System.out.println(e.getAttribute("maxlength")); //HTML attribute
		System.out.println(e.getAttribute("clientHeight"));//HTML Property
		//get value of an attribute of element given by developer in page source
		System.out.println(e.getAttribute("maxlength")); //HTML attribute
		//get value of an attribute of element added by browser only
		System.out.println(e.getDomAttribute("clientHeight")); //HTML Property
		//GET LIst of all properties and attributes
		driver.executeScript("console.dir(arguments[0])", e);
		
		//Retrieve  browser console logs
		LogEntries logs=driver.manage().logs().get(LogType.BROWSER);
		
		//iterate through logs to find console message
		for(LogEntry entry:logs)
		{
			if(entry.getMessage().contains("console")) {
				System.out.println("Console output:: " + entry.getMessage());
				
			}
		}

		
		//close site
		driver.close();
	}

}
