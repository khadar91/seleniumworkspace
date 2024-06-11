package practice;

import java.time.Duration;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Test218 {

	public static void main(String[] args) {
		// Range slider with min and max  both will changed from left to right
		//Take value from keyboard
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter min value as >75");
		int min=scn.nextInt();//99
		System.out.println("Eneter max value >300");
		int max=scn.nextInt(); //349

		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(20));
		//launch site
		driver.get("https://jqueryui.com/slider/#range");
		//set values in range slider
				driver.switchTo().frame(0);
		WebElement minslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='slider-range']/span[1]")));
		while(true)
		{
			WebElement amount=driver.findElement(By.id("amount"));
			String temp=amount.getAttribute("value");
			System.out.println(temp);
			if(temp.contains("$"+min) || temp.contains("$"+(min+1)))
			{
				break;
			}
			else
			{
				Actions act=new Actions(driver);
				act.dragAndDropBy(minslider,1,0).perform();
				//here, one pixel means $2
			}
			
		}
		WebElement maxslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
				                       By.xpath("//div[@id='slider-range']/span[2]")));
		while(true)
		{
			WebElement amount=driver.findElement(By.id("amount"));
			String temp=amount.getAttribute("value");
			System.out.println(temp);
			if(temp.contains("- $"+max))
			{
				break;
			}
			else 
			{
				Actions act=new Actions(driver);
				act.dragAndDropBy(maxslider,1,0).perform();
				
				//here, one pixel means $1
			}
			}
		}
		
		


}
