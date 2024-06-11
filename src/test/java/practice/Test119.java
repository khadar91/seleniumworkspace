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

public class Test119 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);// waiting time to load complete page
		//Locate element and get attribute value and property
		WebElement e=driver.findElement(By.name("identifier"));
		String x=e.getAccessibleName();//internally SWD remembered name
		System.out.println(x);
		String y=e.getAriaRole();//internally SWD remembered type
		System.out.println(y);

		
		//close site
		driver.close();
	}

}
