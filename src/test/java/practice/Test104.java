package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test104 {
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
	
	}
	@Test(priority=2)
	public void method2()
	{
		// 4.Get text of hidden element(developed with paired tag and it has some text)
		//get a blank value ,but no Exception
		WebElement e=driver.findElement(By.xpath("//div[text()='Gender']/following::div[2]"));
		String x=e.getText();
		System.out.println(x);
		//get value using javaScript from hidden element
		String y=(String)driver.executeScript("return(arguments[0].textContent)", e);
		System.out.println(y);
		//close the site
		driver.close();
	}

}
