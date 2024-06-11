package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test103{
	RemoteWebDriver driver;
	@Test(priority=1)
public void method1() throws Exception
{
		//open Browser
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//maximize the browser
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://www.google.co.in");
	Thread.sleep(5000);
}
	@Test(priority=2)
	public void method2()
	{
		//1. Get Text of visible element(developed with paired tag and it has some text)
		//Get Corresponding text successfully
		String x=driver.findElement(By.xpath("//div[@id='gb']/descendant::a[1]"))
				                                                      .getText();
		
		System.out.println(x);
		//2.Get text of Visible element (developed with paired tag but no text)
		// get blank value ,but no Exception
		String y=driver.findElement(By.xpath("//div[@jsname='vdLsw']"))
				                                            .getText();
		
		System.out.println(y);
		//3.Get Text of Visible element(developed with unpaired tags)
		//get a blank value,but no exception
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_hr_test");
		//switch to frame
		driver.switchTo().frame("iframeResult");
		String z=driver.findElement(By.xpath(
				"//h1[text()='The Main Languages of the Web']/following-sibling::hr[1]")).getText();
		System.out.println(z);
		//close site
		driver.close();
	
	}
}
