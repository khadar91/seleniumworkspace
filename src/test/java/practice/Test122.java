package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test122 {
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
		//Do Login
		driver.findElement(By.name("identifier")).sendKeys("venuthurlakhadarvalli");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("vallikhadar15");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		//way-1 locate target element directly
		WebElement e1=driver.findElement(By.xpath("(//table)[6]/tbody/tr[1]/td[4]/dv[1]"));
		String o1=(String)driver.executeScript("return(arguments[0].textContent);", e1);
		System.out.println(o1);
		
		//way-2 locate target Element hierarchically
		WebElement e2=driver.findElement(By.xpath("(//table)[6]/tbody"))
				            .findElement(By.xpath("child::tr[1]"))
				            .findElement(By.xpath("chlild::td[4]"))
			            	.findElement(By.xpath("child::dv[1]"));
		String o2 =(String)driver.executeScript("return(arguments[0].textContent)", e2);
		System.out.println(o2);
		String x[]=o2.split(",");
		System.out.println(x[0].trim()); //read/unread
		System.out.println(x[1].trim()); //"from" address
		System.out.println(x[2].trim()); //subject
		System.out.println(x[3].trim()); //attachment
		System.out.println(x[4].trim()); //received date and time
		System.out.println(x[5].trim()); //mail body
		
		//close site
		driver.close();
		
		
		
		
	}
}
