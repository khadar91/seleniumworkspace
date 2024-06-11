package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeout_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		Duration d=driver.manage().timeouts().getPageLoadTimeout();
		System.out.println(d.getSeconds()); //300
		//Launch site
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
		driver.get("https://google.co.in");
		driver.close();
	}

}
