  package practice;

import java.text.SimpleDateFormat;


import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test127
{
	SimpleDateFormat sf;
	Date dt;
	ATUTestRecorder recorder;
	RemoteWebDriver driver;

	@Test(priority=1)
	public void startRecorder() throws Exception
	{
		sf=new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
		dt=new Date();
		String vp="target\\"+sf.format(dt); // ".MOV" is default extension
		recorder=new ATUTestRecorder(vp,true); //false means no audio
		recorder.start();
	}
	
	@Test(priority=2)
	public void pagnationTesting() throws Exception
	{
		//open browser 
		WebDriverManager.chromedriver().clearDriverCache().setup();
		 WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		//launch ste
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//close banner if exist
				try
				{
				driver.findElement(By.xpath("//span[@role='button']")).click();
				Thread.sleep(5000);
				}
				catch(Exception e)
				{
					System.out.println("no banner exist this tme");
				}
				//click on "mobiles" 
				driver.findElement(By.xpath("//span[text()='Mobiles']/parent::span")).click();
				Thread.sleep(5000);
				//click on "shop now" for 1st product
				driver.findElement(By.xpath("//p[text()='Realme']")).click();
				Thread.sleep(5000);
				//pagination
				int pno=2;
					while(true)
					{
						//goto next page if exist by clicking on page number
						try
						{
							driver.findElement(By.linkText(""+pno)).click();
							Thread.sleep(5000);
							pno++;
						}
						catch(Exception e)
						{
							break; //terminate from loop
						}
				}
		System.out.println(pno);
	}
	@Test(priority=3)
	public void closeSite() throws Exception
	{
		//close site
		driver.close();

	}
	@Test(priority=4)
	public void stopRecording() throws Exception
	{
		//stop Recording
		recorder.stop();
}


}


