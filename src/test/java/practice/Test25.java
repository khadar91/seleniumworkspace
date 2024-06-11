package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test25 {

	public static void main(String[] args)throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame(0);// frame index
		//click on background link
		driver.findElement(By.partialLinkText("Background")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//click on close button
		driver.switchTo().frame(1);
		driver.findElement(By.name("update")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//click on trycoding
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//a[normalize-space()='TRY CODING'][1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

	}

}
