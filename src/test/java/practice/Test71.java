package practice;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test71 {

	public static void main(String[] args) throws Exception
	{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch google
		driver.navigate().to("https://google.co.in");
		Thread.sleep(5000);
		//goto facebook
		URL u=new URL("https://www.facebook.com");
		driver.navigate().to(u);
		Thread.sleep(5000);
		//back to google
		driver.navigate().back();
		Thread.sleep(5000);
		//forwarded to facebook
		driver.navigate().forward();
		Thread.sleep(5000);
		//refresh facebook page
		driver.navigate().refresh();
		Thread.sleep(5000);
		//close site
		driver.close();
		
		

	}

}
