package practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test219 {
	public static void main(String[] args) {
		//Range slider with min and max both will be changed from right to left
		//take value from keyboard
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter min value as <75");
		int min=scn.nextInt();
		System.out.println("Enter max value as <300");
		int max=scn.nextInt();
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define waait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(500));
		//Luanch site
		driver.get("https://jqueryui.com/slider/#range");
		//switch to frame
		driver.switchTo().frame(0);
		WebElement minSlider=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='slider-range']/span[1]")));
		Actions act=new Actions(driver);
		act.clickAndHold(minSlider).perform();
		while(true)
		{
			WebElement amount=driver.findElement(By.id("amount"));
			String temp=amount.getAttribute("value");
			System.out.println(temp);
			if(temp.contains("$"+min)||temp.contains("$"+(min-1)))
			{
				act.release().perform();
			break;
			}
			else
			{
				act.sendKeys(minSlider,Keys.ARROW_LEFT).perform();
				//here, one pixel means $2
				
			}
		}
		WebElement maxSlider=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='slider-range']/span[2]")));
		while(true)
		{
			WebElement amount=driver.findElement(By.id("amount"));
			String temp=amount.getAttribute("value");
			System.out.println(temp);
			if(temp.contains("-$"+max))
			{
			       break;
			}
			else
			{
				//act.dragAndDropBy(maxSlider, -1, 0).perform();
				act.sendKeys(maxSlider,Keys.ARROW_LEFT).perform();
				//here, one pixel means $1
				
			}
		
	}

	}
}

