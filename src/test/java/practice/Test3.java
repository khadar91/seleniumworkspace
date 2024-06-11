package practice;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		// download gecko driver software
		WebDriverManager.firefoxdriver().setup();
		
		//open firefox browser using that browser driver software
		FirefoxDriver driver=new FirefoxDriver();
		
		//launch site
		driver.get("http://www.facebook.com");
		
		//wait few seconds
		
		Thread.sleep(5000);
		
		//close the window browser
		driver.quit();

	}

}
