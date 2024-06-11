package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test237 {

	public static void main(String[] args) {
		// Way-1:code bypassing
		//open browser and launch site and close window push notifications window
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");  //chrome native command as argument
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");

	}

}
