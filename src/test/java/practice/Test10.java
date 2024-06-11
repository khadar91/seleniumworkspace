package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test10 {

	public static void main(String[] args) throws Exception{
		// download chromedriver software
		WebDriverManager.chromedriver().setup();
		//open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.amazon.com");//base url
		Thread.sleep(5000);
		
		//get cureebnt url of page
		String x=driver.getCurrentUrl();
		System.out.println(x);
		if(x.startsWith("https"))
		{
			System.out.println("is secured site");
		}
		else {
			System.out.println("is unsecured site");
		}
		//close site
		driver.close();

	}

}
