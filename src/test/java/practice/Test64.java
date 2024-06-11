package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.DivTableUtility;

public class Test64 {

	public static void main(String[] args) throws Exception
	{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		//search Flights between given stations
		driver.findElement(By.xpath("//div[text()='From']/following::input[1]")).clear();
		driver.findElement(By.xpath("//div[text()='From']/following::input[1]"))
		                                                          .sendKeys("Bengaluru(BLR)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='To']/following::input[1]")).clear();
		driver.findElement(By.xpath("//div[text()='To']/following::input[1]")).sendKeys("Delhi(DEL)");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[text()='23'])[1]")).click(); //date
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(5000);// wait for flights table
		//Flights table developed by <div> tag
		WebElement dt=driver.findElement(By.xpath("//div[text()='SpiceMax']/following::div[2]"));
		DivTableUtility obj=new DivTableUtility();
		int nof=obj.getChildDivCount(dt);
		System.out.println("Count of Flight is:"+nof);
		List<WebElement> flights=obj.getChildDivs(dt);
		int lfare=0;
		for(WebElement flight:flights)
		{
			By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value=obj.getDIVValue(driver, flight, b);
			String num=value.replaceAll("[^0-9]", "");
			if(lfare==0)
			{
				lfare=Integer.parseInt(num);
			}
			else if(lfare>Integer.parseInt(num))
			{
				lfare=Integer.parseInt(num);
				flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name='svg']")).click();
			}
		}
		System.out.println(lfare);
		//close site
		//driver.close();
		
	}

}
    