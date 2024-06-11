package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.CarouselSlider;

public class Test62 {

	public static void main(String[] args) throws Exception
	{
		//carsoul 3d
		//opwn browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		//launch site
		driver.get("http://mdbootstrap.com/docs/b4/jquery/plugins/carousel-3d/");
		//fixed wait
		Thread.sleep(5000);
		CarouselSlider obj=new CarouselSlider();
		for(int i=0;i<=4;i++)
		{
			//locate on WebElement
			WebElement slider=driver.findElement(By.xpath("//div[@class='carousel-3d-inner']"));
			//apply test cases
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

}
