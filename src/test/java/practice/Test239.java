package practice;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test239 {

	public static void main(String[] args) {
		// Way-1 Code bypassing
		//open browser and launch site
		//WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo=new FirefoxOptions();
		fo.addPreference("dom.webnotifications.enabled", false); //firefox native command as args
		FirefoxDriver driver=new FirefoxDriver(fo);
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");

	}

}
