package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CarouselSlider;

public class Test66 {

	public static void main(String[] args) throws Exception 
	{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("https://www.toyota.com.br");
		Thread.sleep(5000);
		//locate carousel  slider(Slick-Carousel is  popular and widely used for java script library
		//for creating responsive and customizable carousel slider on web pages
		WebElement slider=driver.findElement(By.xpath("//div[@class='slick-track'][1]"));
		//apply test cases
		CarouselSlider obj=new CarouselSlider();
		System.out.println(obj.getCountOfSlides(slider));
		System.out.println(obj.getTypeOfSlider(slider));
		
		//are they moving?
		WebElement currentSlideElement=slider.findElement(By.xpath("//*[contains(@class,'slick-current')]"));
		String currentIndexAttribute1=currentSlideElement.findElement(By.xpath("descendant::img")).getAttribute("src");
		Thread.sleep(5000); // wait for some time
		currentSlideElement=slider.findElement(By.xpath("//*[contains(@class,'slick-current')]"));
		String currentIndexAttribute2=currentSlideElement.findElement(By.xpath("descendant::img")).getAttribute("src");
		if(!currentIndexAttribute1.equals(currentIndexAttribute2))
		{
			System.out.println("slides are moving");
		
		//get css property value of the current slide
		String parentLeftvalue=(String)driver.executeScript(
				"return(window.getComputedStyle(arguments[0].parentNode).getPropertyValue('left'));",currentSlideElement);
		//print the value
		System.out.println("prentLeftvalue : "+parentLeftvalue);
		String direction;
		if(parentLeftvalue.contains("-"))
		{
			direction ="Right to Left";
		}
		else
		{
			direction="Left to Right";
		}
		System.out.println("slide direction"+direction);
		}
	else
	{
		System.out.println("slides are not moving");
	}
		System.out.println("Each slide moving direction is "+obj.getSlideMoveDuration(slider));
		System.out.println(obj.getslideMovingStyle(slider));
		System.out.println("Delay between slides is"+obj.grtDelayBetweenSlidesMove(slider));
		//close site 
		driver.close();
}

}
