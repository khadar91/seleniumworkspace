package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CarouselSlider;

public class Test61 {

	public static void main(String[] args)throws Exception
	{
		//download latest chromedriver software
		WebDriverManager.chromedriver().setup();
		//open broowse using that software
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://flipkart.com");
		Thread.sleep(500);
		WebElement slider=driver.findElement(By.xpath("//div[@id='container']//div[contains(@style,'transform')][1]"));
		CarouselSlider obj=new CarouselSlider();
		System.out.println(obj.getCountOfSlides(slider));
		System.out.println(obj.getTypeOfSlider(slider));
		if(obj.areSlidesMovingAutomatically(slider))
		{
			System.out.println(obj.getMovingDirectionOfSlidesInSlider(slider));
		}
		else
		{
			System.out.println("Slides are not moving");
		}
		System.out.println("Each slide moving direction "+obj.getSlideMoveDuration(slider));
		System.out.println(obj.getslideMovingStyle(slider));
		System.out.println("delay between slides is "+obj.grtDelayBetweenSlidesMove(slider));
       //close site
		driver.close();
	}

}
