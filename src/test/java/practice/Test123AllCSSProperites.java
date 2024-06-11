package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123AllCSSProperites {
	RemoteWebDriver driver;
	@Test(priority=1)
public void method1() throws Exception
{
	//open browser
	WebDriverManager.chromedriver().clearDriverCache().setup();
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//maximize the browser 
	driver.manage().window().maximize();
	Thread.sleep(5000);
}
	@Test(priority=2)
	public void method2() throws Exception
	{
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Locate Element
		WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		//1.GET all attributes and properties of the element via console
		//GET all CSS properties of the element via styles tab inspect or via below coding
		String y1=(String) driver.executeScript(
				"var s='';"
				+"var o=window.getComputedStyle(arguments[0]);"
			    +"for(var i=0;i<o.length;i++)"
				+"{"
			    + "s=+o[i]+':'+o.getPropertyValue(o[i])+',';"
			    		+ "}"
			    		+"return(s);",e);
		System.out.println(y1);
		//close site
		driver.close();
		
		
		
		
	}
}
