package practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test131 {
	ATUTestRecorder recorder;
	String vp;
	RemoteWebDriver driver;
	List<String> names;
	List<Integer> prices;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//Start Recorder
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date d=new Date();
		vp="target\\"+sf.format(d);// .mov is default,extension
		recorder=new ATUTestRecorder(vp, false); // false means no audio
		recorder.start();
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//if banner exists close banner
		try
		{
		driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
		Thread.sleep(5000);
	}
catch(Exception e)
		{
	System.out.println("no banner for this time");
		}
}


@Test(priority=3)
public void method3() throws Exception
{
	/*//click on mobile link
	driver.findElement(By.xpath("//span[text()='Mobiles & Tablets']/ancestor::a")).click();
	Thread.sleep(5000);
	//click on Realme link
	driver.findElement(By.xpath("//p[text()='Realme']/ancestor::a")).click();
	Thread.sleep(5000);
	*/
	//Enter search box enter realme click on search button
	driver.findElement(By.name("q")).sendKeys("realme");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	//collect and dispaly names and prices of each model via pagination
	int total=0;
	names=new ArrayList<String>();
	prices=new ArrayList<Integer>();
	while(true) //pagination
	{
		//step-1: collect all models on current page
		List<WebElement> models=driver.findElements(By.xpath("//div[starts-with(@data-id,'MOB')]"));
		total=total+models.size();
		//step-2 
	}
}
}