package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test216 {

	public static void main(String[] args) throws Exception{
		//Navigating to different page using java script
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
driver.get("https://www.facebook.com");
Thread.sleep(5000);
driver.navigate().to("https://www.yahoo.com");
Thread.sleep(5000);
driver.executeScript("window.loaction='https://www.magnitia.com';");

		

	}

}
