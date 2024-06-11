package practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test217 {

	public static void main(String[] args) throws Exception {
		//Range slider with Min is fixed and max will be changed
		//Take value from keyboard
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter a value to set");
		int x=scn.nextInt();
		scn.close();
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("https://rangeslider.js.org");
		Thread.sleep(5000);
		//set max value in range slider bar
		WebElement slider=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='range']")));
		driver.executeScript("$(arguments[0]).val("+x+").change();", slider);
		//get output value
		WebElement sliderout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-output")));
		int y=Integer.parseInt(sliderout.getText());
		 x=(int)(Math.round(x/10.0)*10);
		if(x==y)
		{
			System.out.println("Test passsed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		
		

	}

}
