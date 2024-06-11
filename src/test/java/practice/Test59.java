package practice;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CarouselSlider;

public class Test59 {

	public static void main(String[] args) throws Exception
	{ 
		
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		WebElement slider=driver.findElement(By.className("a-carousel"));
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
