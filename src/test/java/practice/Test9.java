package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test9
{

	public static void main(String[] args) throws Exception
	{
		//download Chromedriver software
		WebDriverManager.chromedriver().setup();
		// open chromeDriverSoftaware 
		RemoteWebDriver driver=new ChromeDriver();
		
		//launch site
		driver.get("https:/www.Amazon.com");
		//wait for few seconds
		Thread.sleep(5000);
		//s varible can be store get titlle
		String s=driver.getTitle();
		//display title name
		System.out.println(s);
		
		//close the browser
		driver.close();

	}

}
